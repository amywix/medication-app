//Amy Wickham 121785021
package com.example.meditime.service;

import com.example.meditime.model.Role;
import com.example.meditime.model.User;
import com.example.meditime.repository.RoleRepository;
import com.example.meditime.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    // Return all users in the system
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // ✅ Corrected: Return users who belong to a given role
    public List<User> getUsersByRole(String roleName) {
        Role role = roleRepository.findByRoleName(roleName)
                .orElseThrow(() -> new RuntimeException("Role not found: " + roleName));
        return userRepository.findByRole(role);
    }

    // Corrected: Add a user and assign a role
    public void addUser(String name, String email, String password, String roleName) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        Role role = roleRepository.findByRoleName(roleName)
                .orElseThrow(() -> new RuntimeException("Role not found: " + roleName));
        user.setRole(role);

        userRepository.save(user);
    }

    // Delete a user by ID
    public boolean deleteUserById(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
