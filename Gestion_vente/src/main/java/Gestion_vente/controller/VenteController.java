package Gestion_vente.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Gestion_vente.entites.Vente;
import Gestion_vente.service.VenteService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/ventes")
@RequiredArgsConstructor
public class VenteController {

    private final VenteService venteService;

    @PostMapping("/valider")
    public Vente validerCommande(
            @RequestParam Long commandeId,
            @RequestParam Long vendeurId) {

        return venteService.validerCommande(commandeId, vendeurId);
    }

    @GetMapping
    public List<Vente> getAll() {
        return venteService.getAllVentes();
    }
    
}