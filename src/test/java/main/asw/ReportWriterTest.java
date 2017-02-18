package main.asw;

import main.asw.report.Factory;
import main.asw.report.ReportWriter;
import main.asw.user.User;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by Pineirin on 18/02/2017.
 */
public class ReportWriterTest {
    @Test
    public void testTxtWriter() {
        User[] users = new User[20];
        users[0] = new User("","", "pablo@gmail.com", new Date(), "", "", "53520961F");
        Factory factory = new Factory();
        ReportWriter reportWriter = factory.createTxtWriter();
        reportWriter.writeReport("Primero.txt", users );
    }

    @Test
    public void testDocxWriter() {
        User[] users = new User[20];
        users[0] = new User("","", "pablo@gmail.com", new Date(), "", "", "53520961F");
        Factory factory = new Factory();
        ReportWriter reportWriter = factory.createDocxWriter();
        reportWriter.writeReport("Segundo.docx", users);
    }

    @Test
    public void testPdfWriter() {
        User[] users = new User[20];
        users[0] = new User("","", "pablo@gmail.com", new Date(), "", "", "53520961F");
        Factory factory = new Factory();
        ReportWriter reportWriter = factory.createPdfWriter();
        reportWriter.writeReport("Tercero.pdf", users);
    }


}