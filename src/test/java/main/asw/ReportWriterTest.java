package main.asw;

import main.asw.report.ReportFactory;
import main.asw.report.ReportWriter;
import main.asw.user.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Pineirin on 18/02/2017.
 */
public class ReportWriterTest {
    @Test
    public void testTxtWriter() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("Pablo", "García", "pineirin@gmail.com", new Date(), "", "Spain", "53520961F"));
        users.add(new User("Pablo", "García", "pablo@gmail.com", new Date(), "", "Spain", "53520961F"));
        ReportFactory factory = new ReportFactory();
        ReportWriter textWriter = factory.createTxtWriter();
        textWriter.writeReport(users);
        //  Files.delete();
    }


    @Test
    public void testDocxWriter() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("Pablo", "García", "pineirin@gmail.com", new Date(), "", "Spain", "53520961F"));
        users.add(new User("Pablo", "García", "pablo@gmail.com", new Date(), "", "Spain", "53520961F"));
        ReportFactory factory = new ReportFactory();
        ReportWriter docxWriter = factory.createDocxWriter();
        docxWriter.writeReport(users);
    }


    @Test
    public void testPdfWriter() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("Pablo", "García", "pineirin@gmail.com", new Date(), "", "Spain", "53520961F"));
        users.add(new User("Pablo", "García", "pablo@gmail.com", new Date(), "", "Spain", "53520961F"));
        ReportFactory factory = new ReportFactory();
        ReportWriter pdfWriter = factory.createPdfWriter();
        pdfWriter.writeReport(users);
    }


}