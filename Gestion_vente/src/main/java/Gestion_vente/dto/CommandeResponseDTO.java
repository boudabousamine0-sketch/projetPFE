package Gestion_vente.dto;

import lombok.Data;

@Data
public class CommandeResponseDTO {
    private Long id;
    private double total;
    private String statut;
}
