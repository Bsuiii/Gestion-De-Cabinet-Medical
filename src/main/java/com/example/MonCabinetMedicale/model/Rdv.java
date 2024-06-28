package com.example.MonCabinetMedicale.model;


import java.time.LocalDateTime;


import com.example.MonCabinetMedicale.Dto.RdvDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Rdv {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDateTime date;
	private String typeMaladie;
	private String description;
	private String notification;

	@JsonIgnore
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name="dossierMedicaleId")
	private DossierMedicale dossierMedicale;

	public Rdv(int id, LocalDateTime date, String typeMaladie, String description, String notification,
			DossierMedicale dossierMedical) {
		super();
		this.id = id;
		this.date = date;
		this.typeMaladie = typeMaladie;
		this.description = description;
		this.notification = notification;
		this.dossierMedicale = dossierMedical;
	}
	public Rdv() {
		super();
	}
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
	public DossierMedicale getDossierMedical() {
		return dossierMedicale;
	}
	public void setDossierMedical(DossierMedicale dossierMedical) {
		this.dossierMedicale = dossierMedical;
	}
	@Override
	public String toString() {
		return "Rdv [id=" + id + ", date=" + date + ", typeMaladie=" + typeMaladie + ", description=" + description
				+ ", notification=" + notification + "]";
	}

	public RdvDto toDto() {
		RdvDto rdvDto =new RdvDto();
		rdvDto.setId(this.getId());
		rdvDto.setDate(this.getDate());
		rdvDto.setDescription(this.getDescription());
		rdvDto.setNotification(this.getNotification());
		rdvDto.setTypeMaladie(this.getTypeMaladie());
		rdvDto.setDossierMedicaleDto(this.getDossierMedical().toDto());
		return rdvDto;
	}





}