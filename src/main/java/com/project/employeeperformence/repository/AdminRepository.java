package com.project.employeeperformence.repository;

import com.project.employeeperformence.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdminRepository extends JpaRepository<Admin, UUID> {

    Admin findByUserNameAndPassword(String userName , String password);
}
