package main.asw.parser;

import java.io.IOException;
import java.text.ParseException;

/**
 * @author nokutu
 * @since 14/02/2017
 */
public interface Parser {

    /**
     * Reads and parses the data from the excel file.
     */
    void readList() throws IOException, ParseException;

    /**
     * Inserts the data into the database.
     */
    void insert();
}
