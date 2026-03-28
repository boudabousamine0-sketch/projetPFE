package Gestion_vente.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;

import Gestion_vente.entites.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
