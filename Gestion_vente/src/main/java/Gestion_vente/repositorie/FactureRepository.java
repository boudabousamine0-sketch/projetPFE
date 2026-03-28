package Gestion_vente.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;

import Gestion_vente.entites.Facture;

public interface FactureRepository extends JpaRepository<Facture,Long> {

}
