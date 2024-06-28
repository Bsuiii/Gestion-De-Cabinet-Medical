package com.example.MonCabinetMedicale.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MonCabinetMedicale.model.Docteur;
import com.example.MonCabinetMedicale.repositories.DocteurRepository;

@Service
public class DocteurService {

	 private final DocteurRepository docteurRepository;

	@Autowired
    public DocteurService(DocteurRepository docteurRepository) {
        this.docteurRepository = docteurRepository;
    }

    public List<Docteur> gelAllDocs() {
    	List<Docteur> list=null;
    	try {

        	list=docteurRepository.findAll();
        	System.err.println(list);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
       return  list;
    }
    public void sendDoctor(Docteur docteur) {
    	docteurRepository.save(docteur);

    }
}
