package com.mayara.client_crud.services;

import com.mayara.client_crud.DTOs.ClientDTO;
import com.mayara.client_crud.entities.Client;
import com.mayara.client_crud.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public ClientDTO findById(Long id){
        Client client= clientRepository.findById(id).get();
        return new ClientDTO(client);
    }


}
