package com.example.library.service;


import com.example.library.model.Client;
import com.example.library.repository.ClientRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public Client update(Long id, Client updatedClient) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
        client.setFullName(updatedClient.getFullName());
        client.setBirthDate(updatedClient.getBirthDate());
        return clientRepository.save(client);
    }
}
