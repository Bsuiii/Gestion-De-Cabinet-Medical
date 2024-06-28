package com.example.MonCabinetMedicale.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MonCabinetMedicale.Dto.RdvDto;
import com.example.MonCabinetMedicale.model.Rdv;
import com.example.MonCabinetMedicale.repositories.RdvRepository;

@Service
public class RdvService {

	@Autowired
	private RdvRepository rdvrepository;

	public List<RdvDto> getAllRdv()
	{
		List<RdvDto> rdvDto=new ArrayList<>();
		List<Rdv> liste=rdvrepository.findAll();
		for(Rdv r:liste) {

			rdvDto.add(r.toDto());

		}

		return  rdvDto;
	}

	public void addRdv(Rdv rdv)
	{
		rdvrepository.save(rdv);
	}

	public List<RdvDto> getAllRdvByDossierMedicale(int id)
	{
		try {
			List<RdvDto> rdvDto=new ArrayList<>();
			List<Rdv> liste=rdvrepository.findAllByDossierMedicaleId(id);
			for(Rdv r:liste) {

				rdvDto.add(r.toDto());

			}

		return  rdvDto;
		} catch (Exception e) {
			return null;
		}
		
	}

	public boolean deleteRdvById(int id) {
		try {
			rdvrepository.deleteById(id);
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}

	}

	public void deleteAllByDossierMedicaleId(int id){
		rdvrepository.deleteAllByDossierMedicaleId(id);
	}
}
