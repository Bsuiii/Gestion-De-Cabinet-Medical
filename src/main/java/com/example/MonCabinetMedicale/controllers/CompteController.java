package com.example.MonCabinetMedicale.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MonCabinetMedicale.model.Compte;
import com.example.MonCabinetMedicale.services.CompteService;

@RestController
public class CompteController {

	@Autowired
	private CompteService compteService;

	@GetMapping("/listAccounts")
	public List<Compte> listAllAccounts(){
		List<Compte> accs=null;
		try {
			accs=compteService.getAllAccounts();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return accs;
	}
}
