package main.asw.parser;

import main.asw.parser.impl.ParserImpl;

import java.io.IOException;

/**
 * Created by nicolas on 15/02/17.
 */
public final class ParserFactory {

    public static ParserImpl getParser(String filename) throws IOException {
        return new ParserImpl(filename);
    }
}
