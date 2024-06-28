package com.example.MonCabinetMedicale.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MonCabinetMedicale.model.Docteur;
import com.example.MonCabinetMedicale.services.DocteurService;

@RestController
public class DocteurController {

	@Autowired
	private  DocteurService docteurService;

	@GetMapping("/list")
	public List<Docteur> listAll(){
		return this.docteurService.gelAllDocs();
	}
	@GetMapping("/send")
	public String saveDoctor(){
		Docteur docteur=new Docteur();
		docteur.setNom("Bessi");
		docteur.setPrenom("Haitam");
		docteur.setCin("GI13728");
		docteur.setSpecialite("Info");
		docteur.setAdresse("Ouled oujih");
		docteurService.sendDoctor(docteur);
		return "Added Succefully";
	}

}
