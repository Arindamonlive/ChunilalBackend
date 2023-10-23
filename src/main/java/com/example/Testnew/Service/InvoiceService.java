package com.example.Testnew.Service;

import com.example.Testnew.Entity.FlatPayment;
import com.example.Testnew.Repository.FlatPaymentRepository;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
//import java.net.http.HttpHeaders;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {
    @Autowired
    private FlatPaymentRepository flatPaymentRepository;
    private FlatPayment flatPayment;


//    public String generateNewInvoice(Long id) {
//        PDDocument document = new PDDocument();
//        PDPage page = new PDPage();
//        document.addPage(page);
//        try {
//            PDPageContentStream contentStream = new PDPageContentStream(document, page);
//
//            // Set up the content for your invoice
//            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
//            contentStream.beginText();
//            contentStream.newLineAtOffset(22, 750);
//            contentStream.showText("Invoice Number: BCCA/"+id);
//            contentStream.showText("Name of the Owner: "+ flatPayment.getFlatDetails());
//            // Add more data as needed
//
//            contentStream.endText();
//            contentStream.close();
//
//            // Save the PDF to a file or send it as a response in your API
////            document.save("invoice.pdf");
//            String filePath = "invoice" + id + ".pdf";
//            document.save(filePath);
//            return filePath;
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            // Handle exceptions appropriately
//        } finally {
//            try {
//                document.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return null;
//    }





//    public FlatPayment generateInvoice(Long id) {
//        PDDocument document = new PDDocument();
//        PDPage page = new PDPage();
//        document.addPage(page);
//
//        try {
//            PDPageContentStream contentStream = new PDPageContentStream(document, page);
//
//            // Fetch the FlatPayment entity based on the provided ID
//            Optional<FlatPayment> optionalFlatPayment = flatPaymentRepository.findById(id);
//            if (optionalFlatPayment.isPresent()) {
//                FlatPayment flatPayment = optionalFlatPayment.get();
//
//                // Set up the content for your invoice
//                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
//                contentStream.beginText();
//                contentStream.newLineAtOffset(22, 750);
//                contentStream.showText("Invoice Number: BCCA/" + id);
//                contentStream.newLineAtOffset(0, -20);
//                contentStream.showText("Dated: "+flatPayment.getCreatedAt());
//                contentStream.newLineAtOffset(0, -20);
//                contentStream.showText("Flat Owner's Name: " + flatPayment.getFlatDetails());
//                contentStream.newLineAtOffset(0, -20);
//                contentStream.showText("Paid Maintenance Amount: Rs." + flatPayment.getPaymentAmount());
//                contentStream.newLineAtOffset(0, -20);
//                contentStream.showText("Paid Dues Amount: Rs." + flatPayment.getDues());
//                // Add more data as needed
//
//                contentStream.endText();
//                contentStream.close();
//
//                // Save the PDF to a file or send it as a response in your API
//                document.save("invoice"+id+".pdf");
//
//            } else {
//                // Handle the case when the FlatPayment with the provided ID is not found
//                // You can return an appropriate response or throw an exception
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//            // Handle exceptions appropriately
//        } finally {
//            try {
//                document.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return null;
//    }










//    public ResponseEntity<byte[]> generatenewInvoice(Long id) {
//        PDDocument document = new PDDocument();
//        // Rest of your code for PDF generation
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        // Your existing code for PDF generation
//
//        try {
//            // Save the PDF content to the ByteArrayOutputStream
//            document.save(byteArrayOutputStream);
//        } catch (IOException e) {
//            e.printStackTrace();
//            // Handle exceptions appropriately
//        } finally {
//            try {
//                document.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        // Set the response headers and return the PDF content as a response
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Disposition", "inline; filename=invoice.pdf");
//
//        return ResponseEntity
//                .ok()
//                .headers(headers)
//                .contentType(MediaType.APPLICATION_PDF)
//                .body(byteArrayOutputStream.toByteArray());
//    }
//
//
//    public ResponseEntity<byte[]> generateInvoice(Long id) {
//        // Fetch the related entities based on the provided ID
//        List<FlatPayment> flatPayments = flatPaymentRepository.findByFlatDetails(id.toString());
//
//        // Create a PDF document
//        PDDocument document = new PDDocument();
//
//        // Iterate through the related entities and add content to the PDF
//        for (FlatPayment flatPayment : flatPayments) {
//            PDPage page = new PDPage();
//            document.addPage(page);
//
//            try {
//                PDPageContentStream contentStream = new PDPageContentStream(document, page);
//
//                // Set up the content for your invoice
//                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
//                contentStream.beginText();
//                contentStream.newLineAtOffset(100, 700);
//                contentStream.showText("Invoice Number: BCCA/" + flatPayment.getId());
//                // Add more data from the entity as needed
//                contentStream.endText();
//                contentStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//                // Handle exceptions appropriately
//            }
//        }
//
//        // Create a ByteArrayOutputStream to store the PDF content
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//
//        try {
//            // Save the PDF content to the ByteArrayOutputStream
//            document.save(byteArrayOutputStream);
//        } catch (IOException e) {
//            e.printStackTrace();
//            // Handle exceptions appropriately
//        } finally {
//            try {
//                document.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        // Set the response headers using Spring's HttpHeaders
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Disposition", "inline; filename=invoice.pdf");
//
//        // Return the PDF content as a response entity
//        return ResponseEntity
//                .ok()
//                .headers(headers)
//                .contentType(MediaType.APPLICATION_PDF)
//                .body(byteArrayOutputStream.toByteArray());
//    }






    public List<FlatPayment> getFmPaymentDetails(String flatDetails){
        return flatPaymentRepository.findByFlatDetails(flatDetails);
//        return flatPaymentRepository.findBy(flatDetails);
    }

    public byte[] generateNewInvoice(Long id) {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        try {
            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Fetch the FlatPayment entity based on the provided ID
            Optional<FlatPayment> optionalFlatPayment = flatPaymentRepository.findById(id);
            if (optionalFlatPayment.isPresent()) {
                FlatPayment flatPayment = optionalFlatPayment.get();

                // Set up the content for your invoice
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
                contentStream.beginText();
                contentStream.newLineAtOffset(22, 750);
                contentStream.showText("Invoice Number: BCCA/" + id);
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText("Dated: "+flatPayment.getCreatedAt());
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText("Flat Owner's Name: " + flatPayment.getFlatDetails());
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText("Paid Maintenance Amount: Rs." + flatPayment.getPaymentAmount());
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText("Paid Dues Amount: Rs." + flatPayment.getDues());
                // Add more data as needed

                contentStream.endText();
                contentStream.close();

                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                document.save(byteArrayOutputStream);
                return byteArrayOutputStream.toByteArray();
            } else {
                // Handle the case when the FlatPayment with the provided ID is not found
                // You can return an appropriate response or throw an exception
            }
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

        return null;
    }

}

