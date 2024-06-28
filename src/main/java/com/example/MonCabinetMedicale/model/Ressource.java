package com.example.MonCabinetMedicale.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ressource {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Nom;
	private String code;
	private String Url;
	private String description;
	public Ressource(int id, String nom, String code, String url, String description) {
		super();
		this.id = id;
		Nom = nom;
		this.code = code;
		Url = url;
		this.description = description;
	}
	public Ressource() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Ressource [id=" + id + ", Nom=" + Nom + ", code=" + code + ", Url=" + Url + ", description="
				+ description + "]";
	}

}