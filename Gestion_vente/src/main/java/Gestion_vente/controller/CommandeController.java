package Gestion_vente.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Gestion_vente.dto.LigneCommandeDTO;
import Gestion_vente.entites.Commande;
import Gestion_vente.service.CommandeService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/commandes")
@RequiredArgsConstructor
public class CommandeController {

    private final CommandeService commandeService;

    @PostMapping
    public Commande passerCommande(
            @RequestParam Long clientId,
            @RequestBody List<LigneCommandeDTO> produits) {

        return commandeService.passerCommande(clientId, produits);
    }
}