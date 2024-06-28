package com.example.MonCabinetMedicale.model;

import java.util.Date;

import com.example.MonCabinetMedicale.Dto.ConsultationDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Consultation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date date;
	private String motif;
	private double prix;

    @JsonIgnore
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name="dossier_medicale_id")
	private DossierMedicale dossierMedicale ;
	public Consultation(int id, Date date, String motif, double prix, DossierMedicale dossierMedicale) {
		super();
		this.id = id;
		this.date = date;
		this.motif = motif;
		this.prix = prix;
		this.dossierMedicale = dossierMedicale;
	}
	public Consultation() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public DossierMedicale getDossierMedicale() {
		return dossierMedicale;
	}
	public void setDossierMedicale(DossierMedicale dossierMedicale) {
		this.dossierMedicale = dossierMedicale;
	}
	@Override
	public String toString() {
		return "Consultation [id=" + id + ", date=" + date + ", motif=" + motif + ", prix=" + prix + "]";
	}

	public ConsultationDto toDto() {
		ConsultationDto ctDto=new ConsultationDto();
		ctDto.setId(this.getId());
		ctDto.setDate(this.getDate());
		ctDto.setMotif(this.getMotif());
		ctDto.setPrix(this.getPrix());
		ctDto.setDossierMedicaleDto(this.getDossierMedicale().toDto());
		return ctDto;
	}


}