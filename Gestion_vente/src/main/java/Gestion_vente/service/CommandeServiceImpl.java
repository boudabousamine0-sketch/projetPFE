package Gestion_vente.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import Gestion_vente.dto.LigneCommandeDTO;
import Gestion_vente.entites.Client;
import Gestion_vente.entites.Commande;
import Gestion_vente.entites.LigneCommande;
import Gestion_vente.entites.Produit;
import Gestion_vente.repositorie.ClientRepository;
import Gestion_vente.repositorie.CommandeRepository;
import Gestion_vente.repositorie.ProduitRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommandeServiceImpl implements CommandeService {

    private final CommandeRepository commandeRepository;
    private final ProduitRepository produitRepository;
    private final ClientRepository clientRepository;

    @Override
    public Commande passerCommande(Long clientId, List<LigneCommandeDTO> produits) {

        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client introuvable"));

        Commande commande = new Commande();
        commande.setDate(new Date());
        commande.setClient(client);

        List<LigneCommande> lignes = new ArrayList<>();
        double total = 0;

        for (LigneCommandeDTO dto : produits) {

            Produit produit = produitRepository.findById(dto.getProduitId())
                    .orElseThrow(() -> new RuntimeException("Produit introuvable"));

            if (produit.getQuantiteStock() < dto.getQuantite()) {
                throw new RuntimeException("Stock insuffisant");
            }

            produit.setQuantiteStock(
                    produit.getQuantiteStock() - dto.getQuantite()
            );

            LigneCommande ligne = new LigneCommande();
            ligne.setProduit(produit);
            ligne.setQuantite(dto.getQuantite());
            ligne.setPrixUnitaire(produit.getPrix());
            ligne.setCommande(commande);

            total += produit.getPrix() * dto.getQuantite();

            lignes.add(ligne);
        }

        commande.setLignes(lignes);
        commande.setTotal(total);

        return commandeRepository.save(commande);
    }
}