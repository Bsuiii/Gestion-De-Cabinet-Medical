package com.example.MonCabinetMedicale.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.MonCabinetMedicale.model.Compte;
import com.example.MonCabinetMedicale.repositories.CompteRepository;

@Service
public class CompteService {

	private final CompteRepository compteRepository;
	
	private   PasswordEncoder passwordEncoder;
	
	@Autowired
	public CompteService(CompteRepository compteRepository) {
		this.compteRepository=compteRepository;
	}
	public List<Compte> getAllAccounts(){
		List<Compte> accs=compteRepository.findAll();
		return accs;

	}
	 public Compte findByEmailAndPassword(String email,String mdps) throws UsernameNotFoundException {
	        Compte compte = compteRepository.findByEmailAndMdps(email,mdps);
	        if (compte == null) {
	            throw new UsernameNotFoundException("User not found");
	        }

	        return compte;
	    }


    public UserDetails findByEmail(String email) throws UsernameNotFoundException {
        Compte compte = compteRepository.findByEmail(email);
        if (compte == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new User(compte.getEmail(), compte.getMdps(), 
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + compte.getRole().getCode())));
    }
    
    public Compte findByUsername(String email) throws UsernameNotFoundException {
        Compte compte = compteRepository.findByEmail(email);
        if (compte == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return compte;
    }
	public void add(Compte compte) {
        String hashedPassword =hashPassword(compte.getMdps());
        compte.setMdps(hashedPassword);
		 compteRepository.save(compte);
	}

	public void updateOnLine(Compte compte) {
		compteRepository.save(compte);
		
	}

	
	  public static String hashPassword(String mdps) {
	        return BCrypt.hashpw(mdps, BCrypt.gensalt());
	    }
}
