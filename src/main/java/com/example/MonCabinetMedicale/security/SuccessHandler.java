package com.example.MonCabinetMedicale.security;

import java.io.IOException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.example.MonCabinetMedicale.model.Compte;
import com.example.MonCabinetMedicale.model.Utilisateur;
import com.example.MonCabinetMedicale.services.CompteService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	
		private Utilisateur utilisateur =null;
		private final CompteService compteService;

	    @Autowired
	    public SuccessHandler(CompteService compteService) {
	        this.compteService = compteService;
	    } 
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
    	System.err.println("Im Inside success handler");
    	UserDetails userDetails = (UserDetails) authentication.getPrincipal();
         String username = userDetails.getUsername();
        
         Compte compte = compteService.findByUsername(username);
        if (compte != null) {
            compte.setOnline(true);
            compteService.updateOnLine(compte);

            utilisateur = compte.getUtilisateur();
            HttpSession session = request.getSession();
            session.setAttribute("userID", utilisateur.getId());
            session.setAttribute("userLastName_Fr", utilisateur.getNom());
            session.setAttribute("userFirstName_Fr", utilisateur.getPrenom());
            session.setAttribute("userRole", compte.getRole().getNom());
            session.setAttribute("userCompte", compte.getId());
        }

        String redirectUrl = determineTargetUrl(authentication);
        if (response.isCommitted()) {
            return;
        }
        getRedirectStrategy().sendRedirect(request, response, redirectUrl);
    }

    protected String determineTargetUrl(Authentication authentication) {
        boolean isAdmin = false;
        boolean isDoctor = false;
        boolean isPatient = false;

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
                isAdmin = true;
                break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_DOCTEUR")) {
                isDoctor = true;
                break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_PATIENT")) {
                isPatient = true;
                break;
            }
        }

        if (isAdmin) {
            return "/E.Admin/index";
        } else if (isDoctor) {
            return "/E.Docteur/dashboard";
        } else if (isPatient) {
            return "/E.Patients/index?id="+ utilisateur.getId();
        } else {
            throw new IllegalStateException();
        }
    }
}