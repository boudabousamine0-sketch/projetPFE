package Gestion_vente.service;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import Gestion_vente.entites.Vente;
import Gestion_vente.repositorie.VenteRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StatistiqueService {

    private final VenteRepository venteRepository;

    // 💰 total ventes
    public double totalVentes() {
        return venteRepository.findAll()
                .stream()
                .mapToDouble(Vente::getTotal)
                .sum();
    }

    // 📦 nombre ventes
    public int nombreVentes() {
        return venteRepository.findAll().size();
    }
    public Map<String, Double> ventesParJour() {

        return venteRepository.findAll()
            .stream()
            .collect(Collectors.groupingBy(
                v -> v.getDate().toString(),
                Collectors.summingDouble(Vente::getTotal)
            ));
    }
}