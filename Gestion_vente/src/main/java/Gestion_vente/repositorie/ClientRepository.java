package Gestion_vente.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;

import Gestion_vente.entites.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
