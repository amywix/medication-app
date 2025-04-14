//Amy Wickham 121785021
package com.example.meditime.repository;

import com.example.meditime.model.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository extends JpaRepository<Client, Long> {
    



    @Override
    public List<Client> findAll();

    @Override
    public Optional<Client> findById(Long id);

    @Override
    public Client save(Client client);

    @Override
    public void deleteById(Long id);
    
}
