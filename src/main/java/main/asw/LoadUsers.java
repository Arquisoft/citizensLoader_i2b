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
        log.info("Running");
        if (args.length == 1) {
            try {
                Parser parser = ParserFactory.getParser(args[0]);
                parser.readList();
                parser.insert();
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }
    }

}
