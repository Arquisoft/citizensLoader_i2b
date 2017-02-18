package main.asw.report;

/**
 * Created by Pineirin on 14/02/2017.
 */
public class Factory {
    private ReportWriter reportWriter;

    /**
     * Method used to create a TxtWriter.
     * @return Returns a reportWriter, int this case a TxtWriter
     */
    public ReportWriter createTxtWriter(){
        reportWriter = new TxtWriter();
        return reportWriter;
    }

    /**
     * Method used to create a DocxWriter.
     * @return Returns a reportWriter, int this case a DocxWriter
     */
    public ReportWriter createDocxWriter(){
        reportWriter = new DocxWriter();
        return reportWriter;
    }

    /**
     * Method used to create a MyPdfWriter.
     * @return Returns a reportWriter, int this case a MyPdfWriter
     */
    public ReportWriter createPdfWriter(){
        reportWriter = new MyPdfWriter();
        return reportWriter;
    }
}
