package org.app.pdfclient;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.app.pdfservice.PDFService;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class PDFContentSegmenter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the path of the PDF file: ");
        String inputFilePath = scanner.nextLine();

        System.out.println("Enter the number of cuts (segments): ");
        int numberOfCuts = scanner.nextInt();

        try {
            // Load PDF
            File pdfFile = new File(inputFilePath);

            if (!pdfFile.exists()) {
                System.out.println("File not found! Please check the path.");
                return;
            }

            // Load the PDF file
            PDDocument document = Loader.loadPDF(pdfFile);
            System.out.println("PDF loaded successfully.");

            // calling the service layer
            PDFService pdfService = new PDFService();
            pdfService.segmentPDF(document, numberOfCuts);

            // Close the document after segmentation
            document.close();
            System.out.println("PDF segmentation completed and document closed.");
        } catch (IOException e) {
            System.err.println("Error loading or processing PDF: " + e.getMessage());
        }
    }
}
