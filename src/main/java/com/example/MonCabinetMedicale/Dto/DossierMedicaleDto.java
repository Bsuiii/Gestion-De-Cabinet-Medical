package com.example.MonCabinetMedicale.Dto;

import java.util.Date;

import com.example.MonCabinetMedicale.model.DossierMedicale;
import com.example.MonCabinetMedicale.model.Patient;

public class DossierMedicaleDto {

	private int id;
	private String Nom;
	private String Emplacement;
	private String description;
	private String allergies;
	private Date dateCreation;
	private String groupSanguin;
	private String traitementEnCours;
	private Patient patient ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "DossierMedicaleDto [id=" + id + ", Nom=" + Nom + ", Emplacement=" + Emplacement + ", description="
				+ description + ", allergies=" + allergies + ", dateCreation=" + dateCreation + ", groupSanguin="
				+ groupSanguin + ", traitementEnCours=" + traitementEnCours + ", patient=" + patient+ "]";
	}



	public DossierMedicale toDossierMedicale() {
        DossierMedicale dossier = new DossierMedicale();
        dossier.setDossier_medicale_id(this.id);
        dossier.setNom(this.Nom);
        dossier.setEmplacement(this.Emplacement);
        dossier.setDescription(this.description);
        dossier.setAllergies(this.allergies);
        dossier.setDateCreation(this.dateCreation);
        dossier.setGroupSanguin(this.groupSanguin);
        dossier.setTraitementEnCours(this.traitementEnCours);
        dossier.setPatient(this.patient);
        return dossier;
    }

}
