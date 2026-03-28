package Gestion_vente.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;

import Gestion_vente.entites.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long> {

}
