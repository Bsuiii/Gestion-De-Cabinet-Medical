package com.example.MonCabinetMedicale.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MonCabinetMedicale.model.DossierMedicale;

@Repository
public interface DossierMedicaleRepository extends JpaRepository<DossierMedicale,Integer> {
	 DossierMedicale findDossierMedicaleByPatientId(int patientId);
}
