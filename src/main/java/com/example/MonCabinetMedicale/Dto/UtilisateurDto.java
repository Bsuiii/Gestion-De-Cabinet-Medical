package com.example.MonCabinetMedicale.Dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.*;


public class UtilisateurDto {
    private int id;
    @NotEmpty(message="le nom est obligatoire")
    private String nom;
    @NotEmpty(message="le prenom est obligatoire")
    private String prenom;
    @NotEmpty(message="veuillez choise le sexe de patient")
    private String sexe;
   // @NotEmpty(message="Cin est Obligatoire")
    private String cin;
    private String nationalite;
    private String adresse;
   @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNais;
    @NotEmpty(message = "Phone number is required")
    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Invalid phone number")
    private String tele;
    @NotEmpty(message = "Email is required")
    @Size(min = 5, message = "Email should have at least 5 characters")
    private String email;
	public UtilisateurDto(int id, String nom, String prenom, String sexe, String cin, String nationalite, String adresse,
			Date dateNais, String tele, String email) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.cin = cin;
		this.nationalite = nationalite;
		this.adresse = adresse;
		this.dateNais = dateNais;
		this.tele = tele;
		this.email = email;
	}
	public UtilisateurDto() {

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getNationalite() {
		return nationalite;
	}
	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Date getDateNais() {
		return dateNais;
	}
	public void setDateNais(Date dateNais) {
		this.dateNais = dateNais;
	}
	public String getTele() {
		return tele;
	}
	public void setTele(String tele) {
		this.tele = tele;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe + ", cin=" + cin
				+ ", nationalite=" + nationalite + ", adresse=" + adresse + ", dateNais=" + dateNais + ", tele=" + tele
				+ ", email=" + email + "]";
	}
}
