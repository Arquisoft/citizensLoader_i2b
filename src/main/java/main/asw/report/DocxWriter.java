package main.asw.report;

import main.asw.user.User;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Pineirin
 * @since 14/02/2017.
 */
public class DocxWriter implements ReportWriter {

    private final static Logger log = LoggerFactory.getLogger(DocxWriter.class);

    @Override
    public void writeReport(ArrayList<User> users) {
        for (User user : users) {
            try (FileOutputStream outputStream = new FileOutputStream(user.getEmail()+ ".docx")) {
                XWPFDocument document = new XWPFDocument();
                XWPFParagraph paragraph = document.createParagraph();
                paragraph.setAlignment(ParagraphAlignment.CENTER);
                XWPFRun run = paragraph.createRun();
                run.setBold(true);
                run.setFontSize(20);
                run.setText("Greetings: " +  user.getFirstName()+ " " + user.getLastName() + ".\n");
                run.setBold(false);
                run.setFontSize(12);
                run.setText("This is your personal information that we have received: \n"
                        + "Date of birth: " + user.getDateOfBirth() + ".\n"
                        + "NIF: " + user.getNif() + ".\n"
                        + "Nationality: " + user.getNationality() + ".\n"
                        + "Addres: " + user.getAddress() + ".\n"
                        + "\n"
                        + "Your password is: " + user.getUnencryptedPass() + ".");
                document.write(outputStream);
                log.info("Exported correctly to docx format");
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }
    }
}
