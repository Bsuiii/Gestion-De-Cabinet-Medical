package com.example.MonCabinetMedicale.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import com.example.MonCabinetMedicale.model.Ressource;
import com.example.MonCabinetMedicale.model.Role;
import com.example.MonCabinetMedicale.repositories.RessourceRepository;

@Service
public class RessourceService {

    @Autowired
    private RessourceRepository ressourceRepository;


    public List<Ressource> getAll(){
    return ressourceRepository.findAll();    
    }

    public void add(Ressource ressource){
        ressourceRepository.save(ressource);
    }

    public void deleteById(int id){
        ressourceRepository.deleteById(id);
    }
    public boolean ressourceExists(String Code){

        if(ressourceRepository.findByCode(Code)!=null)
        return true;

        return false;
       }
      
       public Ressource getRessourceDetailsById(int id)
       {
      	 return ressourceRepository.findById(id).get();
       }
}
