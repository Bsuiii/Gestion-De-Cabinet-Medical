package com.example.MonCabinetMedicale.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Compte {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String email;
	private String mdps;
	@Column(name="date_creation")
	private Date dateCreation;
	private boolean isOnline;
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;
	@ManyToOne
	@JoinColumn(name="utilisateur_id")
	private Utilisateur utilisateur;
	public Compte(int id, String email, String mdps, Date dateCreation, boolean isOnline, Role role,
			Utilisateur utilisateur) {
		super();
		this.id = id;
		this.email = email;
		this.mdps = mdps;
		this.dateCreation = dateCreation;
		this.isOnline = isOnline;
		this.role = role;
		this.utilisateur = utilisateur;
	}
	public Compte() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMdps() {
		return mdps;
	}
	public void setMdps(String mdps) {
		this.mdps = mdps;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public boolean isOnline() {
		return isOnline;
	}
	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	@Override
	public String toString() {
		return "Compte [id=" + id + ", email=" + email + ", mdps=" + mdps + ", dateCreation=" + dateCreation
				+ ", isOnline=" + isOnline + ", role=" + role + ", utilisateur=" + utilisateur + "]";
	}


}