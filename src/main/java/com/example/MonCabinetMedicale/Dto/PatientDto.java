package com.example.MonCabinetMedicale.Dto;

import java.util.Date;

import com.example.MonCabinetMedicale.model.Patient;

public class PatientDto extends UtilisateurDto {

	private String notes;

	public PatientDto(int id, String nom, String prenom, String sexe, String cin, String nationalite, String adresse,
			Date dateNais, String tele, String email, String notes) {

		super(id, nom, prenom, sexe, cin, nationalite, adresse, dateNais, tele, email);
		this.notes = notes;
	}
	public PatientDto() {
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	@Override
	public String toString() {
		return "Patient [notes=" + notes + "]";
	}
    public Patient toPatient(){
        Patient patient=new Patient();
        patient.setId(this.getId());
        patient.setNom(this.getNom());
        patient.setPrenom(this.getPrenom());
        patient.setTele(this.getTele());
        patient.setEmail(this.getEmail());
        patient.setCin(this.getCin());
        patient.setDateNais(this.getDateNais());
        patient.setNationalite(this.getNationalite());
        patient.setNotes(this.getNotes());
        patient.setAdresse(this.getAdresse());
        patient.setSexe(this.getSexe());
       
        return patient;
	
    }
}
