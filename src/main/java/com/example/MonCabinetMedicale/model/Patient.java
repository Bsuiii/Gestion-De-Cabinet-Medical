package com.example.MonCabinetMedicale.model;

import java.util.Date;

import jakarta.persistence.Entity;

@Entity
public class Patient extends Utilisateur {

	private String notes;

	public Patient(int id, String nom, String prenom, String sexe, String cin, String nationalite, String adresse,
			Date dateNais, String tele, String email, String notes) {

		super(id, nom, prenom, sexe, cin, nationalite, adresse, dateNais, tele, email);
		this.notes = notes;
	}
	public Patient() {
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	@Override
	public String toString() {
		return "Patient ["+super.toString()+"notes=" + notes + "]";
	}





}