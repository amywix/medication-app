/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.MediTime.repository;

import com.example.MediTime.model.Client;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author amywi
 */
public interface ClientRepository {

    public List<Client> findAll();

    public Optional<Client> findById(Long id);

    public Client save(Client client);

    public void deleteById(Long id);
    
}
