package main.asw.report;

import main.asw.LoadUsers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Pineirin
 * @since 14/02/2017.
 */
public class TxtWriter implements ReportWriter {

    private final static Logger log = LoggerFactory.getLogger(TxtWriter.class);

    @Override
    public void writeReport(String filename, String content) {
        BufferedWriter bufferedWriter = null;
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(filename);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(content);
            log.info("Exported correctly to txt format");
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException ex) {
                log.error(ex.getMessage(), ex);
            }
        }
    }
}
