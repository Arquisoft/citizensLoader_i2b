package main.asw.report;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Pineirin
 * @since 14/02/2017.
 */
public class DocxWriter implements ReportWriter {

    private final static Logger log = LoggerFactory.getLogger(DocxWriter.class);

    @Override
    public void writeReport(String filename, String content) {
        try (FileOutputStream outputStream = new FileOutputStream(filename)){
            XWPFDocument document = new XWPFDocument();
            XWPFParagraph paragraph = document.createParagraph();
            paragraph.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun run = paragraph.createRun();
            run.setBold(true);
            run.setFontSize(20);
            run.setText(content);
            document.write(outputStream);
            log.info("Exported correctly to docx format");
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }
}
