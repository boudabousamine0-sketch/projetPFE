package Gestion_vente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Gestion_vente.entites.Produit;
import Gestion_vente.repositorie.ProduitRepository;
import Gestion_vente.service.ProduitService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/produits")
@RequiredArgsConstructor
public class ProduitController {

    private final ProduitService produitService;

    @PostMapping
    public Produit save(@RequestBody Produit produit) {
        return produitService.save(produit);
    }

    @GetMapping
    public List<Produit> getAll() {
        return produitService.getAll();
    }
    @GetMapping("/stock-faible")
    public List<Produit> stockFaible() {
        return produitService.getProduitsFaibleStock();
    }
}