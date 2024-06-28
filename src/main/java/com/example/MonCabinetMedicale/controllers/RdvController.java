package com.example.MonCabinetMedicale.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.MonCabinetMedicale.Dto.PatientDto;
import com.example.MonCabinetMedicale.Dto.PatientRegistration;
import com.example.MonCabinetMedicale.Dto.RdvDto;
import com.example.MonCabinetMedicale.model.Compte;
import com.example.MonCabinetMedicale.model.DossierMedicale;
import com.example.MonCabinetMedicale.model.Patient;
import com.example.MonCabinetMedicale.model.Rdv;
import com.example.MonCabinetMedicale.model.Role;
import com.example.MonCabinetMedicale.services.CompteService;
import com.example.MonCabinetMedicale.services.DossierMedicaleService;
import com.example.MonCabinetMedicale.services.EmailService;
import com.example.MonCabinetMedicale.services.PatientService;
import com.example.MonCabinetMedicale.services.RdvService;
import com.util.Util;

import jakarta.validation.Valid;

@Controller
public class RdvController {

	@Autowired
	private RdvService rdvService;

	@Autowired 
	private EmailService emailService;
	
	@Autowired 
	private PatientService patientService;

	@Autowired
	private DossierMedicaleService dossierMedicaleService;
	
	@Autowired
	private CompteService compteService;
	
	@GetMapping("/rendez-vous")
	public String appointments(Model model){
			return "/E.Docteur/appointments";
	}



	@GetMapping("/Rdv")
	@ResponseBody
	public List<RdvDto> listRdv(){
		return rdvService.getAllRdv();
	}

	@GetMapping("/RdvByDm")
	public List<RdvDto> listRdvByDossierMedicale(){
		return rdvService.getAllRdvByDossierMedicale(1);
	}

	@GetMapping("/send-dm")
	public String sendRdv() {
		Rdv rdv=new Rdv();
		DossierMedicale dm=new DossierMedicale();
		dm.setDossier_medicale_id(0);
		rdvService.addRdv(rdv);
		return "Added Succefully";

	}
	@PostMapping("/Patient-rdv/save")
	public String savPatient(@Valid @ModelAttribute("patientRegistration") PatientRegistration patientRegistration,BindingResult bindingResult,Model model){
		System.err.println("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH\n"+patientRegistration.getNom());
		if (bindingResult.hasErrors()) {
			System.err.println("Has Errors :"+bindingResult.getAllErrors());
			return "index";
		}
            
		try {
			Patient patient=new Patient();
			patient.setNom(patientRegistration.getNom());
			patient.setEmail(patientRegistration.getEmail());
			patient.setPrenom(patientRegistration.getPrenom());
			patient.setTele(patientRegistration.getTele());
			patient.setSexe(patientRegistration.getSexe());
			Rdv rdv=new Rdv();
			rdv.setDate(patientRegistration.getDateRdv());
			
			Patient savedPatient=patientService.addPatient(patient);
			DossierMedicale dossierMedicale=new DossierMedicale();
			dossierMedicale.setNom("Dossier-"+savedPatient.getNom());
			dossierMedicale.setPatient(savedPatient);
			dossierMedicale.setDateCreation(new Date());
			dossierMedicale.setTraitementEnCours("En Cours...");
			DossierMedicale savedDossier=dossierMedicaleService.addDossierMedical(dossierMedicale);
			
			try {
				Compte compte =new Compte();
				Role role=new Role();
				String password=Util.generatePassword();
				String Email=patient.getNom()+""+patient.getPrenom()+"@cbm.ma";
				role.setId(1);
				compte.setRole(role);
				compte.setDateCreation(new Date());
				compte.setEmail(Email);
				compte.setMdps(password);
				compte.setOnline(false);
				compte.setUtilisateur(savedPatient);

				compteService.add(compte);
				rdv.setDossierMedical(savedDossier);
				rdvService.addRdv(rdv);
				String subject="Inscription dans la palteforme et details du rdv";
				StringBuilder message=new StringBuilder("Dear "+patient.getPrenom()+" "+patient.getNom()+",");
				message.append("\n Votre Email :"+patient.getPrenom()+""+patient.getNom()+"@cbm.com");
				message.append("\n Votre Mot de Passe :"+((int) (Math.random() * 10000)));
	                       
				emailService.sendSimpleMessage(patient.getEmail(),subject , message.toString());
				System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP\n"+patient);
			} catch (Exception e) {
				System.err.println("RDV ERROR :"+e.getMessage());
			}
			
			patientService.addPatient(patient);
			return "redirect:/home"; 
		} catch (Exception e) {
			System.err.println("ERROR :\n"+ e.getMessage());
			return "redirect:/home"; 
		}
          
    
	}
}
