package main.asw;

import main.asw.report.ReportFactory;
import main.asw.report.ReportWriter;
import main.asw.user.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * @author Pineirin
 * @since 14/02/2017.
 */
public class ReportWriterTest {

    private final static Logger log = LoggerFactory.getLogger(ReportWriterTest.class);

    @Test
    public void testTxtWriter() {
        List<User> users = new ArrayList<>();

        users.add(new User("Pablo", "Pineirin", "pineirin@gmail.com", new Date(), "Gijón", "Spain", "53520961F"));
        users.add(new User("Pablo", "García Marcos", "PabloGarciaMarcos@gmail.com", new Date(), "Gijón", "Spain", "53520961F"));
        users.add(new User("Angel", "Borré Santiago", "AngelBorreSantiago@gmail.com", new Date(), "Navia", "Spain", "65489683N"));

        ReportWriter textWriter = ReportFactory.createTxtWriter();
        textWriter.writeReport(users);

        File file = new File("..\\citizensLoader_i2b\\Generated\\GeneratedTxt\\pineirin@gmail.com.txt");
        File file2 = new File("..\\citizensLoader_i2b\\Generated\\GeneratedTxt\\PabloGarciaMarcos@gmail.com.txt");
        File file3 = new File("..\\citizensLoader_i2b\\Generated\\GeneratedTxt\\AngelBorreSantiago@gmail.com.txt");
        File file4 = new File("pablo@gmail.com.txt");

        assertEquals(true, file.exists());
        assertEquals(true, file2.exists());
        assertEquals(true, file3.exists());
        assertEquals(false, file4.exists());

        String[] lines = Reader(file);
        assertTrue(lines[0].contains("Greetings: Pablo Pineirin."));
        assertTrue(lines[1].contains("This is your personal information that we have received: "));
        assertTrue(lines[7].contains("Your password is: "));

        lines = Reader(file2);
        assertTrue(lines[0].contains("Greetings: Pablo García Marcos."));
        assertTrue(lines[3].contains("NIF: 53520961F"));
        assertTrue(lines[7].contains("Your password is: "));

        lines = Reader(file3);
        assertTrue(lines[0].contains("Greetings: Angel Borré Santiago."));
        assertTrue(lines[5].contains("Addres: Navia"));
        assertTrue(lines[7].contains("Your password is: "));

        assertEquals(true, file.delete());
        assertEquals(true, file2.delete());
        assertEquals(true, file3.delete());
        assertEquals(false, file4.delete());
    }

    @Test
    public void testDocxWriter() {
        List<User> users = new ArrayList<>();

        users.add(new User("Pablo", "Pineirin", "pineirin@gmail.com", new Date(), "Gijón", "Spain", "53520961F"));
        users.add(new User("Pablo", "García Marcos", "PabloGarciaMarcos@gmail.com", new Date(), "Gijón", "Spain", "53520961F"));
        users.add(new User("Angel", "Borré Santiago", "AngelBorreSantiago@gmail.com", new Date(), "Navia", "Spain", "65489683N"));

        ReportWriter docxWriter = ReportFactory.createDocxWriter();
        docxWriter.writeReport(users);

        File file = new File("..\\citizensLoader_i2b\\Generated\\GeneratedDocx\\pineirin@gmail.com.docx");
        File file2 = new File("..\\citizensLoader_i2b\\Generated\\GeneratedDocx\\PabloGarciaMarcos@gmail.com.docx");
        File file3 = new File("..\\citizensLoader_i2b\\Generated\\GeneratedDocx\\AngelBorreSantiago@gmail.com.docx");
        File file4 = new File("pablo@gmail.com.docx");

        assertEquals(true, file.exists());
        assertEquals(true, file2.exists());
        assertEquals(true, file3.exists());
        assertEquals(false, file4.exists());

        assertEquals(true, file.delete());
        assertEquals(true, file2.delete());
        assertEquals(true, file3.delete());
        assertEquals(false, file4.delete());
    }

    @Test
    public void testPdfWriter() {
        List<User> users = new ArrayList<>();

        users.add(new User("Pablo", "Pineirin", "pineirin@gmail.com", new Date(), "Gijón", "Spain", "53520961F"));
        users.add(new User("Pablo", "García Marcos", "PabloGarciaMarcos@gmail.com", new Date(), "Gijón", "Spain", "53520961F"));
        users.add(new User("Angel", "Borré Santiago", "AngelBorreSantiago@gmail.com", new Date(), "Navia", "Spain", "65489683N"));

        ReportWriter pdfWriter = ReportFactory.createPdfWriter();
        pdfWriter.writeReport(users);

        File file = new File("..\\citizensLoader_i2b\\Generated\\GeneratedPdf\\pineirin@gmail.com.pdf");
        File file2 = new File("..\\citizensLoader_i2b\\Generated\\GeneratedPdf\\PabloGarciaMarcos@gmail.com.pdf");
        File file3 = new File("..\\citizensLoader_i2b\\Generated\\GeneratedPdf\\AngelBorreSantiago@gmail.com.pdf");
        File file4 = new File("pablo@gmail.com.pdf");

        assertEquals(true, file.exists());
        assertEquals(true, file2.exists());
        assertEquals(true, file3.exists());
        assertEquals(false, file4.exists());

        assertEquals(true, file.delete());
        assertEquals(true, file2.delete());
        assertEquals(true, file3.delete());
        assertEquals(false, file4.delete());
    }


    @Test
    public void testReportWriter() {
        List<User> users = new ArrayList<>();

        users.add(new User("Pablo", "Pineirin", "pineirin@gmail.com", new Date(), "Gijón", "Spain", "53520961F"));
        users.add(new User("Pablo", "García Marcos", "PabloGarciaMarcos@gmail.com", new Date(), "Gijón", "Spain", "53520961F"));

        ReportWriter textWriter = ReportFactory.createTxtWriter();
        ReportWriter docxWriter = ReportFactory.createDocxWriter();
        ReportWriter pdfWriter = ReportFactory.createPdfWriter();
        textWriter.writeReport(users);
        docxWriter.writeReport(users);
        pdfWriter.writeReport(users);

        File file = new File("..\\citizensLoader_i2b\\Generated\\GeneratedTxt\\pineirin@gmail.com.txt");
        File file2 = new File("..\\citizensLoader_i2b\\Generated\\GeneratedTxt\\PabloGarciaMarcos@gmail.com.txt");
        File file3 = new File("..\\citizensLoader_i2b\\Generated\\GeneratedDocx\\pineirin@gmail.com.docx");
        File file4 = new File("..\\citizensLoader_i2b\\Generated\\GeneratedDocx\\PabloGarciaMarcos@gmail.com.docx");
        File file5 = new File("..\\citizensLoader_i2b\\Generated\\GeneratedPdf\\pineirin@gmail.com.pdf");
        File file6 = new File("..\\citizensLoader_i2b\\Generated\\GeneratedPdf\\PabloGarciaMarcos@gmail.com.pdf");
        File file7 = new File("pineirin@gmail.com.txt");
        File file8 = new File("pablo@gmail.com.pdf");

        assertEquals(true, file.exists());
        assertEquals(true, file2.exists());
        assertEquals(true, file3.exists());
        assertEquals(true, file4.exists());
        assertEquals(true, file5.exists());
        assertEquals(true, file6.exists());
        assertEquals(false, file7.exists());
        assertEquals(false, file8.exists());

        String[] lines = Reader(file);
        assertTrue(lines[0].contains("Greetings: Pablo Pineirin."));
        assertTrue(lines[1].contains("This is your personal information that we have received: "));
        assertTrue(lines[7].contains("Your password is: "));

        lines = Reader(file2);
        assertTrue(lines[0].contains("Greetings: Pablo García Marcos."));
        assertTrue(lines[3].contains("NIF: 53520961F"));
        assertTrue(lines[7].contains("Your password is: "));

        assertEquals(true, file.delete());
        assertEquals(true, file2.delete());
        assertEquals(true, file3.delete());
        assertEquals(true, file4.delete());
        assertEquals(true, file5.delete());
        assertEquals(true, file6.delete());
        assertEquals(false, file7.delete());
        assertEquals(false, file8.delete());
    }

    private String[] Reader(File file) {
        String[] lines = new String[8];
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            StringBuilder sb = new StringBuilder();
            assert bufferedReader != null;
            String line = bufferedReader.readLine();

            int i = 0;
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = bufferedReader.readLine();
                lines[i] = sb.toString();
                i++;
            }

        } catch (IOException e) {
            log.error(e.getMessage(), e);
        } finally {
            try {
                assert bufferedReader != null;
                bufferedReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return lines;
    }

}