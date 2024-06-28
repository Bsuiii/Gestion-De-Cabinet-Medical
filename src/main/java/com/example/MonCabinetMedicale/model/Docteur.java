package com.example.MonCabinetMedicale.model;

import java.util.Date;

import jakarta.persistence.Entity;

@Entity
public class Docteur extends Utilisateur {
	private String specialite;
	private String diplome;
	private String localisation;
	private String horaires;
	public Docteur(int id, String nom, String prenom, String sexe, String cin, String nationalite, String adresse,
			Date dateNais, String tele, String email, String specialite, String diplome, String localisation,
			String horaires) {
		super(id, nom, prenom, sexe, cin, nationalite, adresse, dateNais, tele, email);
		this.specialite = specialite;
		this.diplome = diplome;
		this.localisation = localisation;
		this.horaires = horaires;
	}
	public Docteur() {

	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public String getDiplome() {
		return diplome;
	}
	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}
	public String getLocalisation() {
		return localisation;
	}
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	public String getHoraires() {
		return horaires;
	}
	public void setHoraires(String horaires) {
		this.horaires = horaires;
	}
	@Override
	public String toString() {
		return "Docteur [specialite=" + specialite + ", diplome=" + diplome + ", localisation=" + localisation
				+ ", horaires=" + horaires + "]";
	}


}