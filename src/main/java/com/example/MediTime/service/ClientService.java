package com.example.meditime.service;

import com.example.meditime.model.Client;
import com.example.meditime.repository.ClientRepository;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

   public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client addClient(String name, LocalDate dob, String contact) {
        Client client = new Client(name, dob, contact);
        return clientRepository.save(client);
    }

    

    
   public Client saveClient(Client client) {
    return clientRepository.save(client);
}
   



    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    

    

    
}
