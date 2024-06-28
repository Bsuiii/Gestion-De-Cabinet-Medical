package com.example.MonCabinetMedicale.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MonCabinetMedicale.model.Permission;
import com.example.MonCabinetMedicale.repositories.PermissionRepository;

@Service
public class PermissionService {

	
	@Autowired
	private PermissionRepository permissionRepository;
	
	public List<Permission> getAll() {
		return permissionRepository.findAll();
	}
	
	public void add(Permission permission) {
		permissionRepository.save(permission);
	}
}
