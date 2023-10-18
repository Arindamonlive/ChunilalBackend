package com.example.Testnew.Service;

import com.example.Testnew.Entity.FlatPayment;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class InvoiceService {
    public void generateInvoice(FlatPayment flatPayment) {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        try {
            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Set up the content for your invoice
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
            contentStream.beginText();
            contentStream.newLineAtOffset(100, 700);
            contentStream.showText("Invoice Number: " + flatPayment.getInvoiceNumber());
            // Add more data as needed

            contentStream.endText();
            contentStream.close();

            // Save the PDF to a file or send it as a response in your API
            document.save("invoice.pdf");

        } catch (IOException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        } finally {
            try {
                document.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

