//Amy Wickham 121785021
package com.example.meditime.repository;

import com.example.meditime.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByRole_RoleName(String roleName);

}