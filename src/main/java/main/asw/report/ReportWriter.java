package main.asw.report;

/**
 * Created by jorge on 14/02/2017.
 */
public interface ReportWriter {

    /**
     * Writes the report into the file system.
     */
    void writeReport(String filename, String content);
}
