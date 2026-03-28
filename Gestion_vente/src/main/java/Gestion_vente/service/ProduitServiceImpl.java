package Gestion_vente.service;

import java.util.List;

import org.springframework.stereotype.Service;

import Gestion_vente.entites.Produit;
import Gestion_vente.repositorie.ProduitRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProduitServiceImpl implements ProduitService {

    private final ProduitRepository produitRepository;

    @Override
    public Produit save(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public List<Produit> getAll() {
        return produitRepository.findAll();
    }
    public List<Produit> getProduitsFaibleStock() {

        return produitRepository.findAll()
            .stream()
            .filter(p -> p.getQuantiteStock() < p.getSeuil())
            .toList();
    }
}
