package Gestion_vente.service;

import java.util.List;

import Gestion_vente.entites.Vente;

public interface VenteService {
    Vente validerCommande(Long commandeId, Long vendeurId);
    List<Vente> getAllVentes();
}