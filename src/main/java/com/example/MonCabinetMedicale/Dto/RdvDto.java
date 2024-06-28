package com.example.MonCabinetMedicale.Dto;

import java.time.LocalDateTime;


public class RdvDto {

	private int id;
	private LocalDateTime date;
	private String typeMaladie;
	private String description;
	private String notification;
	private DossierMedicaleDto dossierMedicaleDto;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public String getTypeMaladie() {
		return typeMaladie;
	}
	public void setTypeMaladie(String typeMaladie) {
		this.typeMaladie = typeMaladie;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNotification() {
		return notification;
	}
	public void setNotification(String notification) {
		this.notification = notification;
	}


	public DossierMedicaleDto getDossierMedicaleDto() {
		return dossierMedicaleDto;
	}
	public void setDossierMedicaleDto(DossierMedicaleDto dossierMedicaleDto) {
		this.dossierMedicaleDto = dossierMedicaleDto;
	}
	@Override
	public String toString() {
		return "RdvDto [id=" + id + ", date=" + date + ", typeMaladie=" + typeMaladie + ", description=" + description
				+ ", notification=" + notification + ", dossierMedicaleDto=" + dossierMedicaleDto + "]";
	}



}
