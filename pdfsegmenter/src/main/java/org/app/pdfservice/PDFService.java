package org.app.pdfservice;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.app.pdfmodel.Segment;
import org.app.pdfrepository.PDFRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PDFService {

    private final PDFRepository pdfRepository = new PDFRepository();

    public void segmentPDF(PDDocument document, int numberOfCuts) throws IOException {
        PDFTextStripper stripper = new PDFTextStripper();
        stripper.setSortByPosition(true);  // Sort by position to get content in proper order

        List<Segment> segments = new ArrayList<>();

        for (int page = 0; page < document.getNumberOfPages(); page++) {
            stripper.setStartPage(page + 1);
            stripper.setEndPage(page + 1);

            String pageText = stripper.getText(document);
            segments.addAll(analyzePage(pageText, page));
        }

        // Perform segmentation based on whitespace and save the segmented PDFs
        pdfRepository.makeCuts(document, segments);
    }

    private List<Segment> analyzePage(String text, int page) {
        // Dummy logic to simulate segmentation
        List<Segment> segmentList = new ArrayList<>();

        segmentList.add(new Segment(text, 0, 500, page + 1, page + 1)); // Segment example

        return segmentList;
    }

}
