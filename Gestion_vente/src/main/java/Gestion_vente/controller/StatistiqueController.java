package Gestion_vente.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Gestion_vente.service.StatistiqueService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/statistiques")
@RequiredArgsConstructor
public class StatistiqueController {

    private final StatistiqueService service;

    @GetMapping("/total")
    public double total() {
        return service.totalVentes();
    }

    @GetMapping("/nombre")
    public int nombre() {
        return service.nombreVentes();
    }
}
