package com.example.MonCabinetMedicale.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.MonCabinetMedicale.Dto.RoleDto;
import com.example.MonCabinetMedicale.model.Role;
import com.example.MonCabinetMedicale.services.RoleService;

@RestController
public class RoleController {

@Autowired
private RoleService roleService;

@GetMapping("/Role/List") 
public List<Role> getAllRoles(){
    return roleService.roles();
}

    @PostMapping("/Role/Add")
    @ResponseBody
    public ResponseEntity<String> addRole(@ModelAttribute RoleDto roleDto) {
        if (roleService.roleExists(roleDto.getCode())) {
            return ResponseEntity.ok("false");
        } else {
            Role role = new Role();
            role.setId(roleDto.getId());
            role.setNom(roleDto.getNom());
            role.setCode(roleDto.getCode());
            role.setDescription(roleDto.getDescription());
            role.setDate(roleDto.getDate());
            roleService.add(role);
            return ResponseEntity.ok("true");
        }
    }
    
    @PostMapping("/Role/Update")
    @ResponseBody
    public ResponseEntity<String> updateRole(@ModelAttribute RoleDto roleDto) {
        if (roleService.roleExists(roleDto.getCode())) {
            return ResponseEntity.ok("Code Existe");
        } else {
            Role role = new Role();
            role.setId(roleDto.getId());
            role.setNom(roleDto.getNom());
            role.setCode(roleDto.getCode());
            role.setDescription(roleDto.getDescription());
            role.setDate(roleDto.getDate());
            roleService.add(role);
            return ResponseEntity.ok("Modifie avec succees");
        }
    }
    
    @GetMapping("/Role/Details")
    public Role getDetails(@RequestParam int id) {
        Role role = roleService.getRoleDetailsById(id);
        if (role == null) {
            return null;
        }
        return role;
    }
    
    @GetMapping("/Role/Delete")
    public String delete(@RequestParam int id) {
    try {
    	roleService.deleteById(id);
    	return "Deleted Succefully";
	} catch (Exception e) {
		return "Error Deleting Role";
	}
    	
    }
}

