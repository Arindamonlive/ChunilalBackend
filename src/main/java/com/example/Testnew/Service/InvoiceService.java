package com.example.Testnew.Service;

import com.example.Testnew.Entity.FlatMember;
import com.example.Testnew.Entity.FlatPayment;
import com.example.Testnew.Entity.User;
import com.example.Testnew.Repository.FlatPaymentRepository;
import com.example.Testnew.Repository.UserRepo;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.aspectj.apache.bcel.util.ClassLoaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
//import java.net.http.HttpHeaders;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class InvoiceService {
    @Autowired
    private FlatPaymentRepository flatPaymentRepository;

    private FlatPayment flatPayment;

    private FlatMember flatMember;

    private UserService userService;




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
                Integer amount = null;
                String s = null;
                if(flatPayment.getPaymentAmount()==null){
                    amount = flatPayment.getDues();
                    s= "Monthly Maintenance Dues";
                }
                else{
                    amount =flatPayment.getPaymentAmount();
                    s = "Monthly Maintenance";
                }
                String phone = null;
                phone=flatPayment.getFlatDetails();

                // Set up the content for your invoice
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14);
                contentStream.setLeading(14.5f);

                contentStream.beginText();
                contentStream.newLineAtOffset(40, 770); // Adjust these coordinates as needed
                contentStream.showText("BALIA CHUNILAL CULTURAL ASSOCIATION");
                contentStream.endText();

                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 10);
                contentStream.setLeading(14.5f);

                contentStream.beginText();
                contentStream.newLineAtOffset(40, 760); // Adjust these coordinates as needed
                contentStream.showText("Garia Station Road, Behind Dishari Club, Kolkata, West Bengal,India Pin 700084");
                contentStream.endText();


                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA, 12);
                contentStream.newLineAtOffset(40, 740);
                contentStream.showText("Invoice ID Number: BCCA/" + id);
//                contentStream.newLineAtOffset(0, -20);
//                contentStream.showText("Date: " + flatPayment.getCreatedAt());
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText("");
                contentStream.endText();

                contentStream.setLineWidth(1f);
                contentStream.moveTo(40, 735);
                contentStream.lineTo(555, 735);
                contentStream.stroke();

                // Add customer details
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
                contentStream.beginText();
                contentStream.newLineAtOffset(40, 710);
                contentStream.showText("Bill To:");
                contentStream.endText();

                contentStream.setFont(PDType1Font.HELVETICA, 12);
                contentStream.beginText();
                contentStream.newLineAtOffset(40, 690);
                contentStream.showText("Name: ");
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText("Flat Details : ");
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText("Mobile Number: "+phone);
                contentStream.endText();

                // Add payment details
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
                contentStream.beginText();
                contentStream.newLineAtOffset(360, 710);
                contentStream.showText("Payment Details:");
                contentStream.endText();

                contentStream.setFont(PDType1Font.HELVETICA, 12);
                contentStream.beginText();
                contentStream.newLineAtOffset(360, 690);
                contentStream.showText("Payment Method: Online");
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText("Payment Date: " +flatPayment.getCreatedAt());
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText("Transaction ID: ");
                contentStream.endText();

                // Add line items (you may need a loop for multiple items)
                contentStream.setLineWidth(1f);
                contentStream.moveTo(40, 640);
                contentStream.lineTo(555, 640);
                contentStream.stroke();

                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
                contentStream.beginText();
                contentStream.newLineAtOffset(40, 620);
                contentStream.showText("Description");
                contentStream.newLineAtOffset(240, 0);
//                contentStream.showText("Quantity");
                contentStream.newLineAtOffset(80, 0);
//                contentStream.showText("Unit Price");
                contentStream.newLineAtOffset(80, 0);
                contentStream.showText("Amount");
                contentStream.endText();

                contentStream.setFont(PDType1Font.HELVETICA, 12);
                contentStream.beginText();
                contentStream.newLineAtOffset(40, 600);
                contentStream.showText(s);
                contentStream.newLineAtOffset(240, 0);
//                contentStream.showText("1");
                contentStream.newLineAtOffset(80, 0);
//                contentStream.showText("Rs." + amount);
                contentStream.newLineAtOffset(80, 0);
                contentStream.showText("Rs." + amount);
                contentStream.endText();

                // Add total and other information
                contentStream.setLineWidth(1f);
                contentStream.moveTo(40, 60);
                contentStream.lineTo(555, 60);
                contentStream.stroke();

                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
                contentStream.beginText();
                contentStream.newLineAtOffset(40, 40);
                contentStream.showText("Total Amount Paid");
                contentStream.endText();

                contentStream.setFont(PDType1Font.HELVETICA, 12);
                contentStream.beginText();
                contentStream.newLineAtOffset(490, 40);
                contentStream.showText("Rs." + amount);
                contentStream.endText();

                contentStream.setLineWidth(1f);
                contentStream.moveTo(40, 30);
                contentStream.lineTo(555, 30);
                contentStream.stroke();

                contentStream.setFont(PDType1Font.TIMES_BOLD, 10);
                contentStream.beginText();
                contentStream.newLineAtOffset(40, 15);
                contentStream.showText("This is computer generated invoice no signature required");
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

