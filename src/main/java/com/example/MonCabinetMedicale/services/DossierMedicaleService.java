package com.example.MonCabinetMedicale.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MonCabinetMedicale.Dto.DossierMedicaleDto;
import com.example.MonCabinetMedicale.model.DossierMedicale;
import com.example.MonCabinetMedicale.repositories.DossierMedicaleRepository;
/* import com.example.MonCabinetMedicale.repositories.RdvRepository; */

@Service
public class DossierMedicaleService {

	@Autowired
	private DossierMedicaleRepository  dossierMedicalRepository;

/* 	@Autowired
	private RdvRepository  rdvRepository; */


	public DossierMedicaleDto getDossierMedicaleByPatient(int id){
		DossierMedicale dossierMedicale=null;
		try {
			 dossierMedicale=dossierMedicalRepository.findDossierMedicaleByPatientId(id);
			 System.err.println(dossierMedicale);
			 return dossierMedicale.toDto();
		} catch (Exception e) {
			System.err.println(e.getMessage());

		}
       return null;
		
	}

	public List<DossierMedicale> getAll() {

		 return dossierMedicalRepository.findAll();
	}

	public void deleteDossierMedical(int id) {
		 dossierMedicalRepository.deleteById(id);
   }

    public DossierMedicale addDossierMedical(DossierMedicale dossierMedicale) {
        return dossierMedicalRepository.save(dossierMedicale);
    }
}
