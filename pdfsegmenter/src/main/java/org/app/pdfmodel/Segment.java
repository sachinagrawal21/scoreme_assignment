package org.app.pdfmodel;

public class Segment {

    private final String content;
    private final float yStart;
    private final float yEnd;
    private final int startPage;
    private final int endPage;

    public Segment(String content, float yStart, float yEnd, int startPage, int endPage) {
        this.content = content;
        this.yStart = yStart;
        this.yEnd = yEnd;
        this.startPage = startPage;
        this.endPage = endPage;
    }

    public String getContent() {
        return content;
    }

    public float getYStart() {
        return yStart;
    }

    public float getYEnd() {
        return yEnd;
    }

    public int getStartPage() {
        return startPage;
    }

    public int getEndPage() {
        return endPage;
    }
}
