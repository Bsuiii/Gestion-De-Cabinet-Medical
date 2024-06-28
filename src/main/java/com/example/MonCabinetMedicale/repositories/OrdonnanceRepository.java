package com.example.MonCabinetMedicale.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MonCabinetMedicale.model.Ordonnance;

@Repository
public interface OrdonnanceRepository extends JpaRepository<Ordonnance,Integer> {


     Ordonnance findOrdonnanceByConsultationId(int consultation_Id);
}
