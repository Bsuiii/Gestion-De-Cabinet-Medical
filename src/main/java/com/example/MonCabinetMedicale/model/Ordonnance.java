package com.example.MonCabinetMedicale.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Ordonnance {

    @Id
    private int id;
    private int duree;
    private String description;
    private String medicamentList;
    private String dosage;
    
    @OneToOne
    private Consultation consultation;

    public Ordonnance() {
        // Default constructor
    }

    public Ordonnance(int id, int duree, String description, String medicamentList, String dosage, Consultation consultation) {
        this.id = id;
        this.duree = duree;
        this.description = description;
        this.medicamentList = medicamentList;
        this.dosage = dosage;
        this.consultation = consultation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMedicamentList() {
        return medicamentList;
    }

    public void setMedicamentList(String medicamentList) {
        this.medicamentList = medicamentList;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    @Override
    public String toString() {
        return "Ordonnance [id=" + id + ", duree=" + duree + ", description=" + description + ", medicamentList="
                + medicamentList + ", dosage=" + dosage + ", consultation=" + consultation + "]";
    }
}
