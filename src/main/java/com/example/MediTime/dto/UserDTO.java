//Amy Wickham 121785021
// Amy Wickham 12178502
// File: UserDTO.java
// Description: See MediTime documentation. This file is part of the medication management system.

package com.example.meditime.dto;

import com.example.meditime.model.Role;
import lombok.Data;
import com.example.meditime.model.User;

@Data
public class UserDTO {
    private Long userId;
    private String name;
    private String email;
    private Role role;

    public static UserDTO fromEntity(User user) {
        if (user == null) return null;
        UserDTO dto = new UserDTO();
        dto.setUserId(user.getUserId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        return dto;
    }

    public User toEntity() {
        User user = new User();
        user.setUserId(this.userId);
        user.setName(this.name);
        user.setEmail(this.email);
        user.setRole(this.role);
        return user;
    }
}