//Amy Wickham 121785021
package com.example.meditime.repository;

import com.example.meditime.model.Role;
import com.example.meditime.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    // Returns all users with the given Role
    List<User> findByRole(Role role);
  

Optional<User> findByEmail(String email);

}
