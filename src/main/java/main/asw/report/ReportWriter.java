package main.asw.report;

/**
 * Created by jorge on 14/02/2017.
 */
public interface ReportWriter {

    /**
     * Writes a report in different formats using as filename the first parameter and as content the second.
     * @param filename the name of the file.
     * @param content the content of the generated file.
     */
    void writeReport(String filename, String content);
}
