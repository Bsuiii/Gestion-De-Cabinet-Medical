package com.example.MonCabinetMedicale.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.MonCabinetMedicale.model.Permission;
import com.example.MonCabinetMedicale.services.PermissionService;
import com.example.MonCabinetMedicale.services.RessourceService;
import com.example.MonCabinetMedicale.services.RoleService;

@Controller
public class PermissionController {

	@Autowired 
	private RoleService roleService;
	
	@Autowired 
	private RessourceService ressourceService;
	
	@Autowired 
	private PermissionService permissionService;
	
	@GetMapping("/Permission/List")
	@ResponseBody
	public List<Permission> getAll(){
		
		return permissionService.getAll();
	}
	 @PostMapping("/Permission/Add")
	    @ResponseBody
	    public ResponseEntity<String> addPermissions(@RequestBody String[] permissions) {
	        String message = null;
	        Date d = new Date();
	        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");

	        try {
	            if (permissions != null) {
	                for (String permission : permissions) {
	                    String[] codes = permission.split(":");
	                    int roleID = Integer.parseInt(codes[1]);
	                    int ressourceID = Integer.parseInt(codes[0]);
	                    Permission perm = new Permission();
	                    perm.setRole(roleService.getRoleDetailsById(roleID));
	                    perm.setRessource(ressourceService.getRessourceDetailsById(ressourceID));
	                    perm.setDateMaj(f.parse(f.format(d)));
	                    perm.setPermission(true);
	                    permissionService.add(perm);
	                }
	                message = "Ajout avec Succès";
	            } else {
	                message = "Veuillez cocher une case svp";
	            }
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	            message = e.getMessage();
	        }
	        return ResponseEntity.ok(message);
	    }
	
	}