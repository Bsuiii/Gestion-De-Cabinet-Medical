package com.example.MonCabinetMedicale.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.example.MonCabinetMedicale.services.CompteService;



@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Autowired
	@Lazy
	private CompteService compteService;
	
	 @Autowired
	 private SuccessHandler customSuccessHandler;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		http
		.authorizeHttpRequests((requests)->requests
				.requestMatchers("/home","/","/Patient-rdv/save","/Permission","/send-email","/VerifierCode","/css/*","/images/*","/js/*","/img/*","/lib/*").permitAll()
				.requestMatchers("/E.Docteur/dashboard").hasRole("DOCTEUR")
				.requestMatchers("/E.Admin/index").hasRole("ADMIN")
				.requestMatchers("/E.Patient/index").hasRole("PATIENT")
				.anyRequest().authenticated()
				)
		.formLogin((form)->form
				.loginPage("/login")
				.successHandler(customSuccessHandler)
		        .failureUrl("/home?error")
		        .usernameParameter("username")
		        .passwordParameter("password")
				.permitAll()
				)
		.logout((logout)->logout
				.logoutUrl("/logout")
				.logoutSuccessUrl("/home?logout")
				.invalidateHttpSession(true)
			    .deleteCookies("JSESSIONID")					
				)
		.exceptionHandling((exceptionHandling) -> exceptionHandling
                .accessDeniedPage("/forbidden") 
            )
		  .csrf(csrf -> csrf
	                .ignoringRequestMatchers("/Permission/Add") 
	                .ignoringRequestMatchers("/send-email") 
	            );
		return http.build();
	}
	
	@Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            UserDetails user = compteService.findByEmail(username);
            if (user == null) {
                throw new UsernameNotFoundException("User not found");
            }
            return user;
        };
    }

   @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
