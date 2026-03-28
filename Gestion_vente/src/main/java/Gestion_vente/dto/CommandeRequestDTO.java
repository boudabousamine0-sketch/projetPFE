package Gestion_vente.dto;

import java.util.List;

import lombok.Data;

@Data
public class CommandeRequestDTO {
    private Long clientId;
    private List<LigneCommandeDTO> produits;
}
