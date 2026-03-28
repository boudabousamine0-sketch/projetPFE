package Gestion_vente.service;

import java.util.List;

import Gestion_vente.entites.Produit;

public interface ProduitService {
    Produit save(Produit produit);
    List<Produit> getAll();
    public List<Produit> getProduitsFaibleStock();
}
