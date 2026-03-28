package Gestion_vente.service;

import java.util.List;

import Gestion_vente.dto.CommandeRequestDTO;
import Gestion_vente.dto.CommandeResponseDTO;
import Gestion_vente.dto.LigneCommandeDTO;
import Gestion_vente.entites.Commande;

public interface CommandeService {
    Commande passerCommande(Long clientId, List<LigneCommandeDTO> produits);
}
