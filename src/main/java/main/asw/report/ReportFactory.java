package main.asw.report;

/**
 * Created by Pineirin on 14/02/2017.
 */
public class ReportFactory {

    /**
     * Method used to create a TxtWriter.
     */
    public static ReportWriter createTxtWriter() {
        return new TxtWriter();
    }

    /**
     * Method used to create a DocxWriter.
     */
    public static ReportWriter createDocxWriter() {
        return new DocxWriter();
    }

    /**
     * Method used to create a MyPdfWriter.
     */
    public static ReportWriter createPdfWriter() {
        return new MyPdfWriter();
    }
}
