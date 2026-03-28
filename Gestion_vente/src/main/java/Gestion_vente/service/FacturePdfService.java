package Gestion_vente.service;

import org.springframework.stereotype.Service;

import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import Gestion_vente.entites.Commande;
import Gestion_vente.entites.Facture;
import Gestion_vente.entites.LigneCommande;

@Service
public class FacturePdfService {

    public byte[] generatePdf(Facture facture) throws Exception {

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        PdfWriter writer = new PdfWriter(out);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        // 🧾 titre
        document.add(new Paragraph("FACTURE")
                .setBold()
                .setFontSize(18));

        document.add(new Paragraph("Date: " + facture.getDate()));
        document.add(new Paragraph("Montant: " + facture.getMontant()));

        document.add(new Paragraph(" ")); // espace

        // 📦 Table (3 colonnes)
        Table table = new Table(3);

        table.addCell(new Cell().add(new Paragraph("Produit")));
        table.addCell(new Cell().add(new Paragraph("Quantite")));
        table.addCell(new Cell().add(new Paragraph("Prix")));

        // 🔥 parcourir lignes commande
        Commande commande = facture.getVente().getCommande();

        for (LigneCommande ligne : commande.getLignes()) {

            table.addCell(new Cell().add(
                    new Paragraph(ligne.getProduit().getNom())
            ));

            table.addCell(new Cell().add(
                    new Paragraph(String.valueOf(ligne.getQuantite()))
            ));

            table.addCell(new Cell().add(
                    new Paragraph(String.valueOf(ligne.getPrixUnitaire()))
            ));
        }

        document.add(table);

        document.add(new Paragraph(" "));
        document.add(new Paragraph("TOTAL: " + commande.getTotal())
                .setBold());

        document.close();

        return out.toByteArray();
    }
}