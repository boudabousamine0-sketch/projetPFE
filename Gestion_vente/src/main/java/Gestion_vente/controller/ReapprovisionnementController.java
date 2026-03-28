package Gestion_vente.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Gestion_vente.entites.Reapprovisionnement;
import Gestion_vente.service.ReapprovisionnementService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/reappro")
@RequiredArgsConstructor
public class ReapprovisionnementController {

    private final ReapprovisionnementService service;

    @PostMapping
    public Reapprovisionnement add(
            @RequestParam Long produitId,
            @RequestParam Long fournisseurId,
            @RequestParam int quantite) {

        return service.ajouter(produitId, fournisseurId, quantite);
    }
}