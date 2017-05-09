package main.asw;

import main.asw.parser.Parser;
import main.asw.parser.ParserFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Main application
 *
 * @author Labra
 * @author MIGUEL
 */

public class LoadUsers {

    private final static Logger log = LoggerFactory.getLogger(LoadUsers.class);

    public static void main(String... args) {
        if (args.length == 1) {
            try {
                Parser parser = ParserFactory.getParser(args[0]);
                parser.readList();
                parser.insert();
            } catch (IOException e) {
                printUsage();
            }
        } else {
            printUsage();
        }
    }

    private static void printUsage() {
        System.out.println(
                "Invalid parameters. You must only have:\n" +
                "\t <xls path>"
        );
    }

}
