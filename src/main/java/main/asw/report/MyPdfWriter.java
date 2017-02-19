package main.asw.report;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import main.asw.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.util.ArrayList;


/**
 * @author Pineirin
 * @since 14/02/2017.
 */
public class MyPdfWriter implements ReportWriter {

    private final static Logger log = LoggerFactory.getLogger(DocxWriter.class);

    @Override
    public void writeReport(ArrayList<User> users) {
        for(User user : users) {
            try {
                Document document = new Document();
                PdfWriter.getInstance(document, new FileOutputStream(user.getEmail() + ".pdf"));
                document.open();
                document.add(new Paragraph("Greetings: " + user.getFirstName() + " " + user.getLastName()));
                document.add(new Paragraph("This is your personal information that we have received: "));
                document.add(new Paragraph("Date of birth: " + user.getDateOfBirth() + "."));
                document.add(new Paragraph("NIF: " + user.getNif() + "."));
                document.add(new Paragraph("Nationality: " + user.getNationality() + "."));
                document.add(new Paragraph("Addres: " + user.getAddress() + "."));
                document.add(new Paragraph(" "));
                document.add(new Paragraph("Your password is: " + user.getUnencryptedPass() + "."));
                document.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
