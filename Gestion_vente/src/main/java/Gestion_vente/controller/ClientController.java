package Gestion_vente.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Gestion_vente.entites.Client;
import Gestion_vente.repositorie.ClientRepository;
import Gestion_vente.service.ClientService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public Client save(@RequestBody Client client) {
        return clientService.save(client);
    }
}