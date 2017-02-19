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
                paragraph.setAlignment(ParagraphAlignment.LEFT);
                XWPFRun run = paragraph.createRun();
                run.setBold(true);
                run.setFontSize(20);
                run.setText("Greetings: " +  user.getFirstName()+ " " + user.getLastName());
                XWPFRun run2 = paragraph.createRun();
                run2.addBreak();
                run2.setBold(false);
                run2.setFontSize(12);
                run2.setText("This is your personal information that we have received: ");
                run2.addBreak();
                run2.setText("Date of birth: " + user.getDateOfBirth() + ".");
                run2.addBreak();
                run2.setText("NIF: " + user.getNif() + ".");
                run2.addBreak();
                run2.setText("Nationality: " + user.getNationality() + ".");
                run2.addBreak();
                run2.setText("Addres: " + user.getAddress() + ".");
                run2.addBreak();
                run2.addBreak();
                run2.setText("Your password is: " + user.getUnencryptedPass() + ".");
                run2.addBreak();

                document.write(outputStream);
                log.info("Exported correctly to docx format");
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }
    }
}
