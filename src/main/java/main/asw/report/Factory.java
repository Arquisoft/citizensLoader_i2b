package main.asw.report;

/**
 * Created by Pineirin on 14/02/2017.
 */
public class Factory {

    public Factory() {
        createTxtWriter();
        createDocxWriter();
        createPdfWriter();
    }

    /**
     * Method used to create a TxtWriter.
     */
    public ReportWriter createTxtWriter() {
        return new TxtWriter();
    }

    /**
     * Method used to create a DocxWriter.
     */
    public ReportWriter createDocxWriter() {
        return new DocxWriter();
    }

    /**
     * Method used to create a MyPdfWriter.
     */
    public ReportWriter createPdfWriter() {
        return new MyPdfWriter();
    }
}
