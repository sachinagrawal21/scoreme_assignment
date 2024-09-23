package org.app.pdfrepository;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.app.pdfmodel.Segment;

import java.io.IOException;
import java.util.List;

public class PDFRepository {

    public void makeCuts(PDDocument inputDoc, List<Segment> segments) throws IOException {
        PDPageTree pages = inputDoc.getPages();

        for (int i = 0; i < segments.size(); i++) {
            Segment segment = segments.get(i);
            PDDocument segmentDoc = new PDDocument();

            for (int j = segment.getStartPage(); j <= segment.getEndPage(); j++) {
                PDPage page = pages.get(j - 1);  // Pages are zero-indexed
                segmentDoc.addPage(page);
            }

            System.out.println("Saving segment " + (i + 1));
            segmentDoc.save("Segment_" + (i + 1) + ".pdf");
            segmentDoc.close();
        }

        System.out.println("PDF Segmentation complete.");
    }
}
