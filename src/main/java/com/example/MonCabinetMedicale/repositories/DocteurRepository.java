package com.example.MonCabinetMedicale.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MonCabinetMedicale.model.Docteur;

@Repository
public interface DocteurRepository extends JpaRepository<Docteur,Integer>{

}
