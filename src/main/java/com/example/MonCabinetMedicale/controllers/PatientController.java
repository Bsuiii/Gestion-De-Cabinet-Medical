package com.example.MonCabinetMedicale.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.MonCabinetMedicale.Dto.ConsultationDto;
import com.example.MonCabinetMedicale.Dto.DossierMedicaleDto;
import com.example.MonCabinetMedicale.Dto.PatientDto;
import com.example.MonCabinetMedicale.Dto.RdvDto;
import com.example.MonCabinetMedicale.model.Compte;
import com.example.MonCabinetMedicale.model.Consultation;
import com.example.MonCabinetMedicale.model.DossierMedicale;
import com.example.MonCabinetMedicale.model.Ordonnance;
import com.example.MonCabinetMedicale.model.Patient;
import com.example.MonCabinetMedicale.model.Rdv;
import com.example.MonCabinetMedicale.model.Role;
import com.example.MonCabinetMedicale.services.CompteService;
import com.example.MonCabinetMedicale.services.ConsultationService;
import com.example.MonCabinetMedicale.services.DossierMedicaleService;
import com.example.MonCabinetMedicale.services.EmailService;
import com.example.MonCabinetMedicale.services.OrdonnanceService;
import com.example.MonCabinetMedicale.services.PatientService;
import com.example.MonCabinetMedicale.services.RdvService;
import com.util.Util;

import jakarta.validation.Valid;



@Controller
public class PatientController {

	@Autowired
	private PatientService patientService;

	@Autowired
	private DossierMedicaleService dossierMedicaleService;

	@Autowired
	private RdvService rdvService;

	@Autowired
	private ConsultationService consultationService;

	
	@Autowired
	private OrdonnanceService ordonnanceService;

	@Autowired
	private CompteService compteService;

	@Autowired
	private EmailService emailService;

	@GetMapping("/E.Docteur/List-Patient")
	@ResponseBody
	public List<Patient> listAllPatient(){
		return patientService.getAllPatient();

	}
	@PostMapping("/Patient/save")
	public String savPatient(@Valid @ModelAttribute("patientDto") PatientDto patientDto,BindingResult bindingResult,Model model){
		System.err.println("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH\n"+patientDto.getNom());
		if (bindingResult.hasErrors()) {
			model.addAttribute("hasError", true);
			return "/E.Docteur/Patients";
		}
            
		
            Patient patient=patientDto.toPatient();
			System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP\n"+patient);
			Patient savedPatient=patientService.addPatient(patient);
			DossierMedicale dossierMedicale=new DossierMedicale();
			dossierMedicale.setNom("Dossier-"+savedPatient.getNom());
			dossierMedicale.setPatient(savedPatient);
			dossierMedicale.setDateCreation(new Date());
			dossierMedicale.setTraitementEnCours("En Cours...");
			dossierMedicaleService.addDossierMedical(dossierMedicale);
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

			try {
				compteService.add(compte);
				String subject="Inscription dans la palteforme";
				StringBuilder message=new StringBuilder("Dear "+patient.getPrenom()+" "+patient.getNom()+",");
				message.append("\n Votre Email :"+Email);
				message.append("\n Votre Mot de Passe :"+password);
	                       
				emailService.sendSimpleMessage(patient.getEmail(),subject , message.toString());
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			
			return "redirect:/Patients"; 
    
	}
	@GetMapping("/Patient/update")
	@ResponseBody
	public Patient getPatientInfoById(@RequestParam int patientId){
		System.err.println("PATIENT CONTROLLER ID: "+patientId);
		Patient patient=null;
		try {
			patient=patientService.getPatientById(patientId);
		    Date date_n=patient.getDateNais();
			System.out.println("My Date :"+date_n);
			SimpleDateFormat f=new SimpleDateFormat("dd/MM/yyyy"); 
			String dateUpdate=f.format(date_n);
			patient.setDateNais(f.parse(dateUpdate));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
			return patient;
    
	}
	@PostMapping("/Patient/update")
	public String updatePatient(@Valid @ModelAttribute("patientDto") PatientDto patientDto,BindingResult bindingResult,Model model){
		System.err.println("Patient ID= "+patientDto.getId());
		if (bindingResult.hasErrors()) {
			model.addAttribute("hasError", true);
			return "/E.Docteur/Patients";
		}
            
		
            Patient patient=patientDto.toPatient();
			System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP\n"+patient);
			patientService.updatePatient(patient);
			return "redirect:/Patients"; 
    
	}
	@PostMapping("/Patient/delete")
	@ResponseBody
	public String deletePatient(@RequestParam int patientId) {
		try {
			DossierMedicaleDto dossiermedicaleDto = dossierMedicaleService.getDossierMedicaleByPatient(patientId);
	
			if (dossiermedicaleDto != null) {
				DossierMedicale dossierMedicale = dossiermedicaleDto.toDossierMedicale();
				int dossierId = dossierMedicale.getDossier_medicale_id();
	

				List <RdvDto> rdvs=rdvService.getAllRdvByDossierMedicale(dossierId);
				System.out.println("All Rdvs :"+rdvs);
				if ( !rdvs.isEmpty() || rdvs!=null ) {
					for(RdvDto r:rdvs){
						rdvService.deleteRdvById(r.getId());
					}
				}
	
				List<ConsultationDto> consults = consultationService.getAllConsultsByDossierMedicale(dossierId);
				System.out.println(" All Consults :"+consults);
				if (!consults.isEmpty() || consults != null)
				for (ConsultationDto consult : consults) {
						Ordonnance ord = ordonnanceService.getByConsultation(consult.getId());
						System.out.println("My Ordonnance :"+ord);
						if (ord != null) {
							ordonnanceService.deleteById(ord.getId());
						}
						consultationService.deleteAllByDossierMedicaleId(consult.getId());
					}

				dossierMedicaleService.deleteDossierMedical(dossierId);
			}
	
			patientService.deletePatientById(patientId);
			return "Patient Supprimé";
	
		} catch (Exception e) {
			System.out.println("DELEEEEEEEEEEEEEEEEEEEEEEETE ERROR: " + e.getMessage());
			return "Echec de suppression";
		}
	}
	
	@GetMapping("/Patients")
    public String showRegistrationForm(Model model) {
        model.addAttribute("patientDto", new PatientDto());
        return "/E.Docteur/Patients"; 
    }
	
	@GetMapping("/Patients/Rdv")
    public String rdv_patient(Model model) {
        return "/E.Patients/appointments"; 
    }
}
