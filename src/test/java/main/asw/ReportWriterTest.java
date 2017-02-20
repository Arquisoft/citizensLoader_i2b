package main.asw;

import main.asw.report.ReportFactory;
import main.asw.report.ReportWriter;
import main.asw.user.User;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Pineirin on 18/02/2017.
 */
public class ReportWriterTest {
    @Test
    public void testTxtWriter() {
        List<User> users = new ArrayList<>();

        users.add(new User("Pablo", "Pineirin", "pineirin@gmail.com", new Date(), "Gijón", "Spain", "53520961F"));
        users.add(new User("Pablo", "García Marcos", "PabloGarciaMarcos@gmail.com", new Date(), "Gijón", "Spain", "53520961F"));
        users.add(new User("Angel", "Borré Santiago", "AngelBorreSantiago@gmail.com", new Date(), "Navia", "Spain", "53520961F"));

        ReportWriter textWriter = ReportFactory.createTxtWriter();
        textWriter.writeReport(users);

        File file = new File("..\\citizensLoader_i2b\\Generated\\GeneratedTxt\\pineirin@gmail.com.txt");
        File file2 = new File("..\\citizensLoader_i2b\\Generated\\GeneratedTxt\\PabloGarciaMarcos@gmail.com.txt");
        File file3 = new File("..\\citizensLoader_i2b\\Generated\\GeneratedTxt\\AngelBorreSantiago@gmail.com.txt");
        File file4 = new File ("pablo@gmail.com");

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
    public void testDocxWriter() {
        List<User> users = new ArrayList<>();

        users.add(new User("Pablo", "Pineirin", "pineirin@gmail.com", new Date(), "Gijón", "Spain", "53520961F"));
        users.add(new User("Pablo", "García Marcos", "PabloGarciaMarcos@gmail.com", new Date(), "Gijón", "Spain", "53520961F"));
        users.add(new User("Angel", "Borré Santiago", "AngelBorreSantiago@gmail.com", new Date(), "Navia", "Spain", "53520961F"));

        ReportWriter docxWriter = ReportFactory.createDocxWriter();
        docxWriter.writeReport(users);

        File file = new File("..\\citizensLoader_i2b\\Generated\\GeneratedDocx\\pineirin@gmail.com.docx");
        File file2 = new File("..\\citizensLoader_i2b\\Generated\\GeneratedDocx\\PabloGarciaMarcos@gmail.com.docx");
        File file3 = new File("..\\citizensLoader_i2b\\Generated\\GeneratedDocx\\AngelBorreSantiago@gmail.com.docx");
        File file4 = new File ("pablo@gmail.com");

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
        users.add(new User("Angel", "Borré Santiago", "AngelBorreSantiago@gmail.com", new Date(), "Navia", "Spain", "53520961F"));

        ReportWriter pdfWriter = ReportFactory.createPdfWriter();
        pdfWriter.writeReport(users);

        File file = new File("..\\citizensLoader_i2b\\Generated\\GeneratedPdf\\pineirin@gmail.com.pdf");
        File file2 = new File("..\\citizensLoader_i2b\\Generated\\GeneratedPdf\\PabloGarciaMarcos@gmail.com.pdf");
        File file3 = new File("..\\citizensLoader_i2b\\Generated\\GeneratedPdf\\AngelBorreSantiago@gmail.com.pdf");
        File file4 = new File ("pablo@gmail.com");

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
    public void testReportWriter(){
        List<User> users = new ArrayList<>();

        users.add(new User("Pablo", "Pineirin", "pineirin@gmail.com", new Date(), "Gijón", "Spain", "53520961F"));
        users.add(new User("Pablo", "García Marcos", "PabloGarciaMarcos@gmail.com", new Date(), "Gijón", "Spain", "53520961F"));

        ReportWriter textWriter = ReportFactory.createTxtWriter();
        ReportWriter docxWriter = ReportFactory.createDocxWriter();
        ReportWriter pdfWriter = ReportFactory.createPdfWriter();
        textWriter.writeReport(users);
        docxWriter.writeReport(users);
        pdfWriter.writeReport(users);

        File file = new File("..\\citizensLoader_i2b\\Generated\\GeneratedPdf\\pineirin@gmail.com.pdf");
        File file2 = new File("..\\citizensLoader_i2b\\Generated\\GeneratedPdf\\PabloGarciaMarcos@gmail.com.pdf");
        File file3 = new File ("pablo@gmail.com");

        assertEquals(true, file.exists());
        assertEquals(true, file2.exists());
        assertEquals(false, file3.exists());

        assertEquals(true, file.delete());
        assertEquals(true, file2.delete());
        assertEquals(false, file3.delete());

    }


}