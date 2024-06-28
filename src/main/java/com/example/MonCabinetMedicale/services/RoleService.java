package com.example.MonCabinetMedicale.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.MonCabinetMedicale.model.Role;
import com.example.MonCabinetMedicale.repositories.RoleRepository;

@Service
public class RoleService {


    @Autowired 
    private RoleRepository roleRepository;

    public List<Role> roles(){
        return roleRepository.findAll();
     }

     public void add(Role role){
        roleRepository.save(role);
     }
    
     public void deleteById(int id){
        roleRepository.deleteById(id);
     }
     public boolean roleExists(String Code){

      if(roleRepository.findByCode(Code)!=null)
      return true;

      return false;
     }
    
     public Role getRoleDetailsById(int id)
     {
    	 return roleRepository.findById(id).get();
     }
}
