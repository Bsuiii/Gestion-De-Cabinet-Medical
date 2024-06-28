package com.example.MonCabinetMedicale.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Role {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private Date date;

    public Role(int id, String nom, String code, String description, Date date) {
        super();
        this.id = id;
        this.nom = nom;
        this.code = code;
        this.description = description;
        this.date = date;
    }

    public Role() {
        super();
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Role [id=" + id + ", nom=" + nom + ", code=" + code + ", description=" + description + ", date=" + date + "]";
    }
}
