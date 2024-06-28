package com.example.MonCabinetMedicale.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.MonCabinetMedicale.Dto.RessourceDto;
import com.example.MonCabinetMedicale.model.Ressource;
import com.example.MonCabinetMedicale.services.RessourceService;

@RestController
public class RessourceController {

    @Autowired
    private RessourceService ressourceService;

    @GetMapping("/Ressource/List")
    public List<Ressource> ressources(){
        return ressourceService.getAll();
    }

    @PostMapping("/Ressource/Add")
    @ResponseBody
    public ResponseEntity<String> addressource(@ModelAttribute RessourceDto ressourceDto) {
        if (ressourceService.ressourceExists(ressourceDto.getCode())) {
            return ResponseEntity.ok("false");
        } else {
            Ressource ressource = new Ressource();
            ressource.setId(ressourceDto.getId());
            ressource.setNom(ressourceDto.getNom());
            ressource.setUrl(ressourceDto.getUrl());
            ressource.setCode(ressourceDto.getCode());
            ressource.setDescription(ressourceDto.getDescription());
            ressourceService.add(ressource);
            return ResponseEntity.ok("true");
        }
    }
    
    @PostMapping("/Ressource/Update")
    @ResponseBody
    public ResponseEntity<String> updateressource(@ModelAttribute RessourceDto ressourceDto) {
        if (ressourceService.ressourceExists(ressourceDto.getCode())) {
            return ResponseEntity.ok("Code Existe");
        } else {
            Ressource ressource = new Ressource();
            ressource.setId(ressourceDto.getId());
            ressource.setNom(ressourceDto.getNom());
            ressource.setUrl(ressourceDto.getUrl());
            ressource.setCode(ressourceDto.getCode());
            ressource.setDescription(ressourceDto.getDescription());
            ressourceService.add(ressource);
            return ResponseEntity.ok("Modifie avec succees");
        }
    }
    
    @GetMapping("/Ressource/Details")
    public Ressource getDetails(@RequestParam int id) {
    	Ressource ressource = ressourceService.getRessourceDetailsById(id);
        if (ressource == null) {
            return null;
        }
        return ressource;
    }
    
    @GetMapping("/Ressource/Delete")
    public String delete(@RequestParam int id) {
    try {
    	ressourceService.deleteById(id);
    	return "Deleted Succefully";
	} catch (Exception e) {
		return "Error Deleting ressource";
	}
    	
    }
    
    @PostMapping("/Perms/Add")
	  public String debbuger() {
		 return "hello world";
	 }	 
}
