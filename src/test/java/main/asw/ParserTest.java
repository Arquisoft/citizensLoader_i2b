package main.asw;

import main.asw.parser.Parser;
import main.asw.parser.ParserFactory;
import main.asw.user.User;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import java.io.IOException;
import java.text.ParseException;

/**
 * Created by nicolas on 15/02/17.
 */
public class ParserTest {

    private final static String TESTOKFILENAME = "pruebaUsuarios.xls";
    private final static String TESTBADDATEAFTERTODAY = "badDateAfterToday.xls";
    private final static String TESTBADDATEFORMAT = "badDateFormat.xls";
    private final static String TESTNOFOUNDFILE = "noExiste";
    private static final String TESTLESSLINES = "lessLines.xls";
    private static final String TESTMORELINES = "moreLines.xls";


    Parser parser;


    @Test
    public void testAllOKFile() throws IOException, ParseException {
        try {
            parser = ParserFactory.getParser(TESTOKFILENAME);
        } catch (IOException e) {e.printStackTrace();}

        String baseName = "Prueba";
        String baseSurname = "Apellido";
        String baseEmail = "prueba";
        String baseStreet = "c/Prueba n0 1a";
        String baseCountry = "España";
        String baseId = "000000";//01J
        parser.readList();
        assertEquals(20, parser.getUsers().size());
        for(int i = 0; i < parser.getUsers().size(); i++){
            String index = (i+1 < 10)? "0"+(i+1):(i+1)+"";
            User user = parser.getUsers().get(i);
            assertEquals(baseName+index, user.getName());
            assertEquals(baseSurname+index, user.getSurname());
            assertEquals(baseEmail+index+"@prueba.es", user.getEmail());
            assertEquals(baseStreet, user.getAddress());
            assertEquals(baseCountry, user.getNationality());
            assertEquals(baseId+index+"J", user.getDni());
        }
    }

    @Test(expected = IOException.class)
    public void testNoFoundFile() throws IOException {
        parser = ParserFactory.getParser(TESTNOFOUNDFILE);
    }

    @Test(expected = ParseException.class)
    public void testestbaddateaftertoday() throws IOException, ParseException {
        parser = ParserFactory.getParser(TESTBADDATEAFTERTODAY);
        parser.readList();
    }

    @Test(expected = ParseException.class)
    public void testBadDateFormat() throws IOException, ParseException {
        parser = ParserFactory.getParser(TESTBADDATEFORMAT);
        parser.readList();
    }

    @Test(expected = ParseException.class)
    public void testMoreLines() throws IOException, ParseException {
        parser = ParserFactory.getParser(TESTMORELINES);
        parser.readList();
    }

    @Test(expected = ParseException.class)
    public void testLessLines()throws IOException, ParseException {
        parser = ParserFactory.getParser(TESTLESSLINES);
        parser.readList();
    }



}
