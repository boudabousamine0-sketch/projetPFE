package Gestion_vente.service;

import java.util.List;

import Gestion_vente.entites.Facture;

public interface FactureService {
    List<Facture> getAllFactures();
    Facture getFactureById(Long id);
}