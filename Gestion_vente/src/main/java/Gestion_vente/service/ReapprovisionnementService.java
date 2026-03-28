package Gestion_vente.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import Gestion_vente.entites.Fournisseur;
import Gestion_vente.entites.Produit;
import Gestion_vente.entites.Reapprovisionnement;
import Gestion_vente.repositorie.fournisseurRepository;
import Gestion_vente.repositorie.ProduitRepository;
import Gestion_vente.repositorie.ReapprovisionnementRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReapprovisionnementService {

    private final ProduitRepository produitRepository;
    private final fournisseurRepository fournisseurRepository;
    private final ReapprovisionnementRepository repo;

    public Reapprovisionnement ajouter(Long produitId, Long fournisseurId, int quantite) {

        Produit produit = produitRepository.findById(produitId).get();
        Fournisseur fournisseur = fournisseurRepository.findById(fournisseurId).get();

        // ➕ زيادة stock
        produit.setQuantiteStock(
            produit.getQuantiteStock() + quantite
        );

        // 🧾 إنشاء reapprovisionnement
        Reapprovisionnement r = new Reapprovisionnement();
        r.setDate(new Date());
        r.setQuantite(quantite);
        r.setProduit(produit);
        r.setFournisseur(fournisseur);

        return repo.save(r);
    }
}