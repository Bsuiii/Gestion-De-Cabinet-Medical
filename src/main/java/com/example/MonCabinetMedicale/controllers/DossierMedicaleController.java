package com.example.MonCabinetMedicale.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.MonCabinetMedicale.Dto.ConsultationOrdonnanceDto;
import com.example.MonCabinetMedicale.Dto.DossierMedicaleDto;
import com.example.MonCabinetMedicale.model.DossierMedicale;
import com.example.MonCabinetMedicale.services.ConsultationService;
import com.example.MonCabinetMedicale.services.DossierMedicaleService;
import com.example.MonCabinetMedicale.services.PatientService;
import com.example.MonCabinetMedicale.services.RdvService;

@Controller
public class DossierMedicaleController {

	@Autowired
	private DossierMedicaleService dossierMedicaleService;

    @Autowired
	private RdvService rdvService;

	@Autowired
	private ConsultationService consultationService;
	@Autowired
	private PatientService patientService;

	@GetMapping("/DossierMedical")
public String getDm(@RequestParam int id, Model model) {
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

    return "/E.Docteur/DossierMedical";
}

	@GetMapping("/AllDm")
	public List<DossierMedicale> listAll() {

		return dossierMedicaleService.getAll();

	}

}
