package com.example.MonCabinetMedicale.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MonCabinetMedicale.model.Rdv;

@Repository
public interface RdvRepository extends JpaRepository<Rdv,Integer> {

	List<Rdv> findAllByDossierMedicaleId(int dossierMedicalId);
	void deleteAllByDossierMedicaleId(int dossierMedicaleId);
}
