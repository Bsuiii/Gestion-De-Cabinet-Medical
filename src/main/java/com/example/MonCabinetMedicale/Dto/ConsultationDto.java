package com.example.MonCabinetMedicale.Dto;

import java.util.Date;


public class ConsultationDto {

	private int id;
	private Date date;
	private String motif;
	private double prix;
	private DossierMedicaleDto dossierMedicaleDto ;
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
	public DossierMedicaleDto getDossierMedicaleDto() {
		return dossierMedicaleDto;
	}
	public void setDossierMedicaleDto(DossierMedicaleDto dossierMedicaleDto) {
		this.dossierMedicaleDto = dossierMedicaleDto;
	}
	@Override
	public String toString() {
		return "ConsultationDto [id=" + id + ", date=" + date + ", motif=" + motif + ", prix=" + prix
				+ ", dossierMedicaleDto=" + dossierMedicaleDto + "]";
	}




}
