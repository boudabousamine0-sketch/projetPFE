package Gestion_vente.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;

import Gestion_vente.entites.Vente;

public interface VenteRepository extends JpaRepository<Vente, Long>{

}
