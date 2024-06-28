package com.example.MonCabinetMedicale.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MonCabinetMedicale.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer>{

    Role findByCode(String Code);
}
