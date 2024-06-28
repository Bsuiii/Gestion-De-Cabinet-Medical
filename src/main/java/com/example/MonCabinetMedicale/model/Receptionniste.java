package com.example.MonCabinetMedicale.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Receptionniste extends Utilisateur {

	@Column(name="code_recept")
	private String codeRecept;

	public Receptionniste(int id, String nom, String prenom, String sexe, String cin, String nationalite,
			String adresse, Date dateNais, String tele, String email, String codeRecept) {
		super(id, nom, prenom, sexe, cin, nationalite, adresse, dateNais, tele, email);
		this.codeRecept = codeRecept;
	}

	public Receptionniste() {
	}

	public String getCodeRecept() {
		return codeRecept;
	}

	public void setCodeRecept(String codeRecept) {
		this.codeRecept = codeRecept;
	}

	@Override
	public String toString() {
		return "Receptionniste [codeRecept=" + codeRecept + "]";
	}


}