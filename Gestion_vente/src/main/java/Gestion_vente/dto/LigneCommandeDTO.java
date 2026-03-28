package Gestion_vente.dto;

import lombok.Data;

@Data
public class LigneCommandeDTO {
    private Long produitId;
    private int quantite;
}