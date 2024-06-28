package com.example.MonCabinetMedicale.model;

import java.util.Date;
import java.util.List;

import com.example.MonCabinetMedicale.Dto.DossierMedicaleDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name="dossiermedicale")
public class DossierMedicale{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String Nom;
	private String Emplacement;
	private String description;
	private String allergies;
	private Date dateCreation;
	private String groupSanguin;
	private String traitementEnCours;

	@OneToOne( cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="patient_id")
	private Patient patient ;

	@OneToMany(mappedBy = "dossierMedicale", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Rdv> rendez_vous;

	@OneToMany(mappedBy = "dossierMedicale", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Consultation> consults;

	public DossierMedicale(int dossier_medicale_id, String nom, String emplacement, String description,
			String allergies, Date dateCreation, String groupSanguin, String traitementEnCours, Patient patient,
			List<Rdv> rendez_vous, List<Consultation> consults) {
		super();
		this.id = dossier_medicale_id;
		Nom = nom;
		Emplacement = emplacement;
		this.description = description;
		this.allergies = allergies;
		this.dateCreation = dateCreation;
		this.groupSanguin = groupSanguin;
		this.traitementEnCours = traitementEnCours;
		this.patient = patient;
		this.rendez_vous = rendez_vous;
		this.consults = consults;
	}
	public DossierMedicale() {
		super();
	}
	public int getDossier_medicale_id() {
		return this.id;
	}
	public void setDossier_medicale_id(int dossier_medicale_id) {
		this.id = dossier_medicale_id;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getEmplacement() {
		return Emplacement;
	}
	public void setEmplacement(String emplacement) {
		Emplacement = emplacement;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAllergies() {
		return allergies;
	}
	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public String getGroupSanguin() {
		return groupSanguin;
	}
	public void setGroupSanguin(String groupSanguin) {
		this.groupSanguin = groupSanguin;
	}
	public String getTraitementEnCours() {
		return traitementEnCours;
	}
	public void setTraitementEnCours(String traitementEnCours) {
		this.traitementEnCours = traitementEnCours;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public List<Rdv> getRendez_vous() {
		return rendez_vous;
	}
	public void setRendez_vous(List<Rdv> rendez_vous) {
		this.rendez_vous = rendez_vous;
	}
	public List<Consultation> getConsults() {
		return consults;
	}
	public void setConsults(List<Consultation> consults) {
		this.consults = consults;
	}
	@Override
	public String toString() {
		return "DossierMedicale [dossier_medicale_id=" + id + ", Nom=" + Nom + ", Emplacement="
				+ Emplacement + ", description=" + description + ", allergies=" + allergies + ", dateCreation="
				+ dateCreation + ", groupSanguin=" + groupSanguin + ", traitementEnCours=" + traitementEnCours
				+ ", patient=" + patient + ", rendez_vous=" + rendez_vous + ", consults=" + consults + "]";
	}

	public DossierMedicaleDto toDto() {
		DossierMedicaleDto dossierMedicaleDto=new DossierMedicaleDto();
		dossierMedicaleDto.setId(this.getDossier_medicale_id());
		dossierMedicaleDto.setNom(this.getNom());
		dossierMedicaleDto.setAllergies(this.getAllergies());
		dossierMedicaleDto.setDateCreation(this.getDateCreation());
		dossierMedicaleDto.setDescription(this.getDescription());
		dossierMedicaleDto.setEmplacement(this.getEmplacement());
		dossierMedicaleDto.setGroupSanguin(this.getGroupSanguin());
		dossierMedicaleDto.setPatient(this.getPatient());
		dossierMedicaleDto.setTraitementEnCours(this.getTraitementEnCours());
		return dossierMedicaleDto;


	}


}