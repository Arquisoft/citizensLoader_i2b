package main.asw.report;

/**
 * Created by Pineirin on 14/02/2017.
 */
public class Factory {
    private ReportWriter reportWriter;

    public ReportWriter createTxtWriter(){
        reportWriter = new TxtWriter();
        return reportWriter;
    }

    public ReportWriter createDocxWriter(){
        reportWriter = new DocxWriter();
        return reportWriter;
    }

    public ReportWriter createPdfWriter(){
        reportWriter = new PdfWriter();
        return reportWriter;
    }
}
