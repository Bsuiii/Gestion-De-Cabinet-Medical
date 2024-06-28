package com.example.MonCabinetMedicale.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MonCabinetMedicale.model.Ressource;

@Repository
public interface RessourceRepository extends JpaRepository<Ressource,Integer>{

	Ressource findByCode(String code);

}
