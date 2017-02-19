package main.asw.report;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import main.asw.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.util.List;


/**
 * @author Pineirin
 * @since 14/02/2017.
 */
class MyPdfWriter implements ReportWriter {

    private final static Logger log = LoggerFactory.getLogger(DocxWriter.class);

    @Override
    public void writeReport(List<User> users) {
        for (User user : users) {
            try {
                Document document = new Document();
                PdfWriter.getInstance(document, new FileOutputStream("..\\citizensLoader_i2b\\Generated\\GeneratedPdf\\" + user.getEmail() + ".pdf"));
                document.open();
                addText(user, document);
                document.close();
                log.info("Exported correctly to docx format");
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
    }

    /**
     * Auxiliar method that adds all the text to the pdf.
     *
     * @param user     the user whose information we want to print.
     * @param document the document that we want to generate.
     * @throws DocumentException
     */
    private void addText(User user, Document document) throws DocumentException {
        document.add(new Paragraph("Greetings: " + user.getFirstName() + " " + user.getLastName()));
        document.add(new Paragraph("This is your personal information that we have received: "));
        document.add(new Paragraph("Date of birth: " + user.getDateOfBirth() + "."));
        document.add(new Paragraph("NIF: " + user.getNif() + "."));
        document.add(new Paragraph("Nationality: " + user.getNationality() + "."));
        document.add(new Paragraph("Addres: " + user.getAddress() + "."));
        document.add(new Paragraph(" "));
        document.add(new Paragraph("Your password is: " + user.getUnencryptedPass() + "."));
    }
}
