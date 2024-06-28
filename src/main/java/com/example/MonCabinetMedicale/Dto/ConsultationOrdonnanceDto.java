package com.example.MonCabinetMedicale.Dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.MonCabinetMedicale.model.DossierMedicale;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public class ConsultationOrdonnanceDto {

    private int dossierId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @NotEmpty(message="le motif est obligatoire")
    private String motif;
    @Min(0)
    private double prix;
    private String medicament;
    private String dosage;
    private int duree;

  
    public ConsultationOrdonnanceDto() {
    }

    public ConsultationOrdonnanceDto(int dossierId, Date date, String motif, double prix, String medicament,
            String dosage, int duree) {
        this.dossierId = dossierId;
        this.date = date;
        this.motif = motif;
        this.prix = prix;
        this.medicament = medicament;
        this.dosage = dosage;
        this.duree = duree;
    }

    
    public int getDossierId() {
        return dossierId;
    }

    public void setDossierId(int dossierId) {
        this.dossierId = dossierId;
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

    public String getMedicament() {
        return medicament;
    }

    public void setMedicament(String medicament) {
        this.medicament = medicament;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    
    @Override
    public String toString() {
        return "ConsultationOrdonnanceDto [dossierId=" + dossierId + ", date=" + date + ", motif=" + motif + ", prix="
                + prix + ", medicament=" + medicament + ", dosage=" + dosage + ", duree=" + duree + "]";
    }
}
