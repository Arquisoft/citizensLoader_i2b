package main.asw.parser;

import java.io.IOException;

/**
 * Created by nicolas on 15/02/17.
 */
public final class ParserFactory {

    public static Parser getParser(String filename) throws IOException {
        return new Parser(filename);
    }
}
