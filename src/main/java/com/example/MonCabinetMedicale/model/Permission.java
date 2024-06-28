package com.example.MonCabinetMedicale.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Permission {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private boolean Permission;
	private Date dateMaj;
	@ManyToOne
	private Role role;
	@ManyToOne
	private Ressource ressource;
	public Permission(int id, boolean permission, Date dateMaj, Role role, Ressource ressource) {
		super();
		this.id = id;
		Permission = permission;
		this.dateMaj = dateMaj;
		this.role = role;
		this.ressource = ressource;
	}
	public Permission() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isPermission() {
		return Permission;
	}
	public void setPermission(boolean permission) {
		Permission = permission;
	}
	public Date getDateMaj() {
		return dateMaj;
	}
	public void setDateMaj(Date dateMaj) {
		this.dateMaj = dateMaj;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Ressource getRessource() {
		return ressource;
	}
	public void setRessource(Ressource ressource) {
		this.ressource = ressource;
	}
	@Override
	public String toString() {
		return "Permission [id=" + id + ", Permission=" + Permission + ", dateMaj=" + dateMaj + ", role=" + role
				+ ", ressource=" + ressource + "]";
	}

}