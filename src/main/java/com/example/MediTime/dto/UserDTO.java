package com.example.MediTime.dto;

import com.example.MediTime.model.Role;
import lombok.Data;
import com.example.MediTime.model.User;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private Role role;

    public static UserDTO fromEntity(User user) {
        if (user == null) return null;
        UserDTO dto = new UserDTO();
        dto.setId(user.getUserId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        return dto;
    }

    public User toEntity() {
        User user = new User();
        user.setUserId(this.id);
        user.setName(this.name);
        user.setEmail(this.email);
        user.setRole(this.role);
        return user;
    }
}