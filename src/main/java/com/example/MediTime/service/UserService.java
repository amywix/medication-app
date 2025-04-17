//Amy Wickham 121785021
package com.example.meditime.service;

import com.example.meditime.model.Role;
import com.example.meditime.model.User;
import com.example.meditime.repository.RoleRepository;
import com.example.meditime.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService implements org.springframework.security.core.userdetails.UserDetailsService {


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

    @Autowired
private PasswordEncoder passwordEncoder;



public void addUser(String name, String email, String password, String roleName) {
    User user = new User();
    user.setName(name);
    user.setEmail(email);
    user.setPassword(passwordEncoder.encode(password));

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
    
    // Check if email already exists
public boolean emailExists(String email) {
    return userRepository.findByEmail(email).isPresent();
}

    @Override
public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));

    return org.springframework.security.core.userdetails.User.builder()
            .username(user.getEmail())
            .password(user.getPassword())
            .roles(user.getRole().getRoleName()) // Role must be a single string like "Carer"
            .build();
}

public User validateUser(String email, String password) {
    Optional<User> optionalUser = userRepository.findByEmail(email);
    if (optionalUser.isPresent()) {
        User user = optionalUser.get();
        if (user.getPassword().equals(password)) { // if using encryption, use passwordEncoder.matches()
            return user;
        }
    }
    return null;
}

}
