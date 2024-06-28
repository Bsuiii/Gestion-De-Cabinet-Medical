package com.example.MonCabinetMedicale.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MonCabinetMedicale.model.Patient;
import com.example.MonCabinetMedicale.repositories.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;

	public List<Patient> getAllPatient(){
	return patientRepository.findAll();
	}

	public boolean deletePatientById(int id) {
		try {
			patientRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}

	}

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }
	public Patient getPatientById(int patientId) {
		System.err.println("PATIENT SERVICE ID: "+patientId);
		Patient patient=null;
		try {
			patient=patientRepository.findById(patientId).get();
			System.err.println("PATIENT SERVICE : "+patient);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
        return patient;
    }

	public void updatePatient(Patient patient) {
		patientRepository.save(patient);
	}

}
