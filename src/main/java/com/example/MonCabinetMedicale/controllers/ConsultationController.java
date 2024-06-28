package com.example.MonCabinetMedicale.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.MonCabinetMedicale.Dto.ConsultationDto;
import com.example.MonCabinetMedicale.Dto.ConsultationOrdonnanceDto;
import com.example.MonCabinetMedicale.model.Consultation;
import com.example.MonCabinetMedicale.model.DossierMedicale;
import com.example.MonCabinetMedicale.model.Ordonnance;
import com.example.MonCabinetMedicale.services.ConsultationService;
import com.example.MonCabinetMedicale.services.OrdonnanceService;

import jakarta.validation.Valid;

@Controller
public class ConsultationController {

	@Autowired
	private ConsultationService consultationService;

	@Autowired
	private OrdonnanceService ordonnanceService;

	@GetMapping({"/Consults","/consults"})
	public List<ConsultationDto> getAllConsults(){
		return consultationService.getAllConsults();
	}

	@GetMapping({"/ConsultsByDm","/consultsbydm"})
	public List<ConsultationDto> getAllConsultsByDossierMdicale(){
		return consultationService.getAllConsults();
	}

	@PostMapping("/consultation/save")
    public String saveConsultationAndOrdonnance(
                                                @Valid @ModelAttribute ConsultationOrdonnanceDto dto, BindingResult result) {
        if (result.hasErrors()) {

			return "/DossierMedical?id="+dto.getDossierId();
        }

        Consultation consultation = new Consultation();
        consultation.setDate(dto.getDate());
        consultation.setMotif(dto.getMotif());
        consultation.setPrix(dto.getPrix());
		DossierMedicale dossierMedicale=new DossierMedicale();
		dossierMedicale.setDossier_medicale_id(dto.getDossierId());
        consultation.setDossierMedicale(dossierMedicale);
        Consultation savedconsultaion=consultationService.add(consultation);

       
        Ordonnance ordonnance = new Ordonnance();
        ordonnance.setMedicamentList(dto.getMedicament());
        ordonnance.setDosage(dto.getDosage());
        ordonnance.setDuree(dto.getDuree());
        ordonnance.setConsultation(savedconsultaion); 
        ordonnanceService.addOrdonnance(ordonnance);

        return "/DossierMedical?id="+dto.getDossierId();
    }
}
