package Gestion_vente.service;

import org.springframework.stereotype.Service;

import Gestion_vente.entites.Client;
import Gestion_vente.repositorie.ClientRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }
}