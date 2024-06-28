package com.example.MonCabinetMedicale.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MonCabinetMedicale.Dto.ConsultationDto;
import com.example.MonCabinetMedicale.model.Consultation;
import com.example.MonCabinetMedicale.repositories.ConsultationRepository;

@Service
public class ConsultationService {

	@Autowired
	private ConsultationRepository consultationRepository;

	public List<ConsultationDto> getAllConsults()
	{
		List<ConsultationDto> ConsultationDto=new ArrayList<>();
		List<Consultation> liste=consultationRepository.findAll();
		for(Consultation c:liste) {

			ConsultationDto.add(c.toDto());

		}

		return  ConsultationDto;
	}

	public List<ConsultationDto> getAllConsultsByDossierMedicale(int id)
	{
		List<ConsultationDto> ConsultationDto=new ArrayList<>();
		List<Consultation> liste=consultationRepository.findAllByDossierMedicaleId(id);
		for(Consultation c:liste) {

			ConsultationDto.add(c.toDto());

		}

		return  ConsultationDto;
	}

	public void deleteAllByDossierMedicaleId(int id){
		consultationRepository.deleteAllByDossierMedicaleId(id);
	}

	public Consultation add(Consultation cons){
		return consultationRepository.save(cons);
	}
}
