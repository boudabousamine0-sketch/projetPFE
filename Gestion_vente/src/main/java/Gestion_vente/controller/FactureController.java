package Gestion_vente.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Gestion_vente.entites.Facture;
import Gestion_vente.service.FacturePdfService;
import Gestion_vente.service.FactureService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/factures")
@RequiredArgsConstructor
public class FactureController {

    private final FactureService factureService;
    private final FacturePdfService facturePdfService;

    @GetMapping
    public List<Facture> getAll() {
        return factureService.getAllFactures();
    }

    @GetMapping("/{id}")
    public Facture getById(@PathVariable Long id) {
        return factureService.getFactureById(id);
    }
    
    @GetMapping("/{id}/pdf")
    public ResponseEntity<byte[]> getPdf(@PathVariable Long id) throws Exception {

        Facture facture = factureService.getFactureById(id);

        byte[] pdf = facturePdfService.generatePdf(facture);

        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=facture.pdf")
                .body(pdf);
    }
}