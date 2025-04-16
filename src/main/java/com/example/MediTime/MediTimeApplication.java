package com.example.meditime;

import com.example.meditime.model.Role;
import com.example.meditime.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MediTimeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MediTimeApplication.class, args);
    }

    // ✅ Seed roles on startup
    @Bean
    public ApplicationRunner seedRoles(@Autowired RoleRepository roleRepository) {
        return args -> {
            createRoleIfNotExists(roleRepository, "Manager");
            createRoleIfNotExists(roleRepository, "Carer");
        };
    }

    private void createRoleIfNotExists(RoleRepository roleRepository, String roleName) {
        if (roleRepository.findByRoleName(roleName).isEmpty()) {
            Role role = new Role();
            role.setRoleName(roleName);
            roleRepository.save(role);
            System.out.println("Created role: " + roleName);
        }
    }
}
