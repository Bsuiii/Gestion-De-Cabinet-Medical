package com.example.MonCabinetMedicale.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MonCabinetMedicale.model.Receptionniste;


@Repository
public interface ReceptionnisteRepository  extends JpaRepository<Receptionniste,Integer>{

}
