
package com.example.MediTime.repository;

import com.example.MediTime.model.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author amywi
 */


public interface ClientRepository extends JpaRepository<Client, Long>{

    public List<Client> findAll();

    public Optional<Client> findById(Long id);

    public Client save(Client client);

    public void deleteById(Long id);
    
}
