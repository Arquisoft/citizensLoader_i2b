package main.asw.report;

import main.asw.user.User;

/**
 * Created by jorge on 14/02/2017.
 */
public interface ReportWriter {

    /**
     * Writes a report in different formats using as filename the first parameter and as content the second.
     * @param filename the name of the file.
     * @param users the users whose information we need to print.
     */
    void writeReport(String filename, User[] users);
}
