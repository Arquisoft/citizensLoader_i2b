package main.asw.report;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;


/**
 * @author Pineirin
 * @since 14/02/2017.
 */
public class MyPdfWriter implements ReportWriter {

    private final static Logger log = LoggerFactory.getLogger(DocxWriter.class);

    @Override
    public void writeReport(String filename, String content) {
        try{
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(filename));
            document.open();
            document.add(new Paragraph("Hello World!"));
            document.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
