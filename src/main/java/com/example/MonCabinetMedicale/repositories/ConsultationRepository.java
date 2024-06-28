package com.example.MonCabinetMedicale.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MonCabinetMedicale.model.Consultation;



public interface ConsultationRepository extends JpaRepository<Consultation,Integer> {

	 List<Consultation> findAllByDossierMedicaleId(int dossierMedicaleId);
     void deleteAllByDossierMedicaleId(int dossierMedicaleId);
}
