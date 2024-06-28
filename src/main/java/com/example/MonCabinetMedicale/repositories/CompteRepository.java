package com.example.MonCabinetMedicale.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MonCabinetMedicale.model.Compte;

@Repository
public interface CompteRepository extends JpaRepository<Compte,Integer> {

	Compte findByEmail(String email);
	Compte findByEmailAndMdps(String email,String mdps);
}
