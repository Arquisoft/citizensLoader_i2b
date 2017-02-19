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
import java.util.List;

/**
 * @author Pineirin
 * @since 14/02/2017.
 */
class DocxWriter implements ReportWriter {

    private final static Logger log = LoggerFactory.getLogger(DocxWriter.class);

    @Override
    public void writeReport(List<User> users) {
        for (User user : users) {
            try (FileOutputStream outputStream = new FileOutputStream(user.getEmail() + ".docx")) {
                XWPFDocument document = new XWPFDocument();
                XWPFParagraph paragraph = document.createParagraph();
                paragraph.setAlignment(ParagraphAlignment.LEFT);
                addTitle(user, paragraph);
                XWPFRun run2 = addText(user, paragraph);
                addLine(run2, "Your password is: " + user.getUnencryptedPass() + ".");
                document.write(outputStream);
                log.info("Exported correctly to docx format");
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }
    }

    private void addTitle(User user, XWPFParagraph paragraph) {
        XWPFRun run = paragraph.createRun();
        run.setBold(true);
        run.setFontSize(20);
        addLine(run, "Greetings: " + user.getFirstName() + " " + user.getLastName());
    }

    private XWPFRun addText(User user, XWPFParagraph paragraph) {
        XWPFRun run = paragraph.createRun();
        run.setBold(false);
        run.setFontSize(12);
        addLine(run, "This is your personal information that we have received: ");
        addLine(run, "Date of birth: " + user.getDateOfBirth() + ".");
        addLine(run, "NIF: " + user.getNif() + ".");
        addLine(run, "Nationality: " + user.getNationality() + ".");
        addLine(run, "Addres: " + user.getAddress() + ".");
        run.addBreak();
        return run;
    }

    private void addLine(XWPFRun run, String line) {
        run.setText(line);
        run.addBreak();
    }
}
