package com.example.MonCabinetMedicale.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.MonCabinetMedicale.Dto.ConsultationOrdonnanceDto;
import com.example.MonCabinetMedicale.Dto.DossierMedicaleDto;
import com.example.MonCabinetMedicale.Dto.PatientRegistration;
import com.example.MonCabinetMedicale.Dto.RessourceDto;
import com.example.MonCabinetMedicale.Dto.RoleDto;
import com.example.MonCabinetMedicale.model.DossierMedicale;
import com.example.MonCabinetMedicale.model.Permission;
import com.example.MonCabinetMedicale.services.ConsultationService;
import com.example.MonCabinetMedicale.services.DossierMedicaleService;
import com.example.MonCabinetMedicale.services.PatientService;
import com.example.MonCabinetMedicale.services.RdvService;

@Controller
public class IndexController {

	@Autowired
	private DossierMedicaleService dossierMedicaleService;

    @Autowired
	private RdvService rdvService;

	@Autowired
	private ConsultationService consultationService;
	@Autowired
	private PatientService patientService;
	
	
    @GetMapping({"/home","","/"})
    public String index(Model model){
        model.addAttribute("patientRegistration",new PatientRegistration());
        return "index";
    }
    @GetMapping("/E.Docteur/dashboard")
    public String login(){
        return "E.Docteur/index";
    }
   @GetMapping("/E.Admin/index")
    public String patients(Model model){
        model.addAttribute("RoleDto", new RoleDto());
        model.addAttribute("RessourceDto", new RessourceDto());
        model.addAttribute("Permission",new Permission());
        return "E.Admin/index";
    } 
   
   @GetMapping("/E.Patients/index")
   public String medicalFile(Model model,@RequestParam int id){
	   DossierMedicaleDto dossierMedicale = dossierMedicaleService.getDossierMedicaleByPatient(id);
	    model.addAttribute("ConsultationOrdonnanceDto", new ConsultationOrdonnanceDto());
		model.addAttribute("md_id",id);

	    if (dossierMedicale != null) {
	        int dossierId = dossierMedicale.getId();
	        model.addAttribute("dossierMedical", dossierMedicale);
	        model.addAttribute("rdvs", rdvService.getAllRdvByDossierMedicale(dossierId));
	        model.addAttribute("consults", consultationService.getAllConsultsByDossierMedicale(dossierId));
	    } else {
	        DossierMedicale ds = new DossierMedicale();
	        ds.setPatient(patientService.getPatientById(id));
	        model.addAttribute("dossierMedical", ds);
	        model.addAttribute("rdvs", null);
	        model.addAttribute("consults", null);
	    }
	    return "/E.Patients/Dossier-Medical";
   } 
   @GetMapping("/forbidden")
   public String forbidden(){
       return "layouts/forbidden";
   } 
   
   
}
