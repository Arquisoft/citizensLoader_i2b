package main.asw.report;

/**
 * Created by Pineirin on 14/02/2017.
 */
public class Factory {
    private ReportWriter txtWriter;
    private ReportWriter docxWriter;
    private ReportWriter pdfWriter;

    public Factory() {
        createTxtWriter();
        createDocxWriter();
        createPdfWriter();
    }

    /**
     * Method used to create a TxtWriter.
     */
    private void createTxtWriter() {
        txtWriter = new TxtWriter();
    }

    /**
     * Method used to create a DocxWriter.
     */
    private void createDocxWriter() {
        docxWriter = new DocxWriter();
    }

    /**
     * Method used to create a MyPdfWriter.
     */
    private void createPdfWriter() {
        pdfWriter = new MyPdfWriter();
    }

    public ReportWriter getTxtWriter() {
        return txtWriter;
    }

    public ReportWriter getDocxWriter() {
        return docxWriter;
    }

    public ReportWriter getPdfWriter() {
        return pdfWriter;
    }
}
