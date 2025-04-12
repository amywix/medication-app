/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.example.MediTime.service;

import com.example.MediTime.model.Client;
import com.example.MediTime.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    public Client saveClient(Client client) {
         System.out.println("Saving client: " + client.getName());
        return clientRepository.save(client);
        
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }


}