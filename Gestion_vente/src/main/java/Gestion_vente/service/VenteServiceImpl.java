package Gestion_vente.service;


import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import Gestion_vente.entites.Commande;
import Gestion_vente.entites.Facture;
import Gestion_vente.entites.Utilisateur;
import Gestion_vente.entites.Vente;
import Gestion_vente.repositorie.CommandeRepository;
import Gestion_vente.repositorie.FactureRepository;
import Gestion_vente.repositorie.UtilisateurRepository;
import Gestion_vente.repositorie.VenteRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VenteServiceImpl implements VenteService {

    private final CommandeRepository commandeRepository;
    private final VenteRepository venteRepository;
    private final FactureRepository factureRepository;
    private final UtilisateurRepository utilisateurRepository;

    public Vente validerCommande(Long commandeId, Long vendeurId) {

        Commande commande = commandeRepository.findById(commandeId)
                .orElseThrow(() -> new RuntimeException("Commande introuvable"));

        Utilisateur vendeur = utilisateurRepository.findById(vendeurId)
                .orElseThrow(() -> new RuntimeException("Vendeur introuvable"));

        // vérifier role
        if (!vendeur.getRole().toString().equals("VENDEUR")) {
            throw new RuntimeException("Utilisateur non autorisé");
        }

        // changer statut
        commande.setStatut("VALIDEE");

        // créer vente
        Vente vente = new Vente();
        vente.setDate(LocalDate.now());
        vente.setTotal(commande.getTotal());
        vente.setCommande(commande);
        vente.setVendeur(vendeur);

        venteRepository.save(vente);

        // créer facture automatiquement
        Facture facture = new Facture();
        facture.setDate(LocalDate.now());
        facture.setMontant(commande.getTotal());
        facture.setVente(vente);

        factureRepository.save(facture);

        return vente;
    }

    public List<Vente> getAllVentes() {
        return venteRepository.findAll();
    }
}