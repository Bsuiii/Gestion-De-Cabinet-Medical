package com.example.MonCabinetMedicale.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MonCabinetMedicale.model.Compte;
import com.example.MonCabinetMedicale.model.Ordonnance;
import com.example.MonCabinetMedicale.repositories.OrdonnanceRepository;

@Service
public class OrdonnanceService {

    @Autowired
    private OrdonnanceRepository ordonnanceRepository;


    public Ordonnance getByConsultation(int id){
        try {
            Ordonnance ord=ordonnanceRepository.findOrdonnanceByConsultationId(id);
            return ord;
        } catch (Exception e) {
            System.out.println(" Ordonnance getter Service Error :"+e.getMessage());
        }
        return null;
    }
    public void deleteById(int id){
        try {
            ordonnanceRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Ordonnance Delete Serviec Error :"+e.getMessage());
        }
    }

    public Ordonnance addOrdonnance(Ordonnance ord){
        return ordonnanceRepository.save(ord);
    }
}
