package Gestion_vente.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;

import Gestion_vente.entites.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

}
