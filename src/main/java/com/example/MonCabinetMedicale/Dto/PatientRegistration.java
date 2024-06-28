package com.example.MonCabinetMedicale.Dto;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.*;

public class PatientRegistration extends PatientDto {

	@NotNull(message = "Veuillez entrer la date du rdv")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dateRdv;

public PatientRegistration(int id, String nom, String prenom, String sexe, String cin, String nationalite,
		String adresse, Date dateNais, String tele, String email, String notes, LocalDateTime date) {
	super(id, nom, prenom, sexe, cin, nationalite, adresse, dateNais, tele, email, notes);
	this.dateRdv = date;
}

public PatientRegistration() {
	super();
}

public LocalDateTime getDateRdv() {
	return dateRdv;
}

public void setDateRdv(LocalDateTime date) {
	this.dateRdv = date;
}

@Override
public String toString() {
	return "PatientRegistration [date=" + dateRdv + "]";
}
   
   
   

}
