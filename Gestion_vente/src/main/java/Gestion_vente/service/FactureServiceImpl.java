package Gestion_vente.service;

import java.util.List;

import org.springframework.stereotype.Service;

import Gestion_vente.entites.Facture;
import Gestion_vente.repositorie.FactureRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FactureServiceImpl implements FactureService {

    private final FactureRepository factureRepository;

    @Override
    public List<Facture> getAllFactures() {
        return factureRepository.findAll();
    }

    @Override
    public Facture getFactureById(Long id) {
        return factureRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Facture introuvable"));
    }
}