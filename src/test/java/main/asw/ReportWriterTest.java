package main.asw;

import main.asw.report.Factory;
import main.asw.report.ReportWriter;
import main.asw.user.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by Pineirin on 18/02/2017.
 */
public class ReportWriterTest {
    @Test
    public void testTxtWriter() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("Pablo","García", "pineirin@gmail.com", new Date(), "", "Spain", "53520961F"));
        users.add(new User("Pablo","García", "pablo@gmail.com", new Date(), "", "Spain", "53520961F"));
        Factory factory = new Factory();
        ReportWriter reportWriter = factory.createTxtWriter();
        reportWriter.writeReport(users );
    }


    @Test
    public void testDocxWriter() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("Pablo","García", "pineirin@gmail.com", new Date(), "", "Spain", "53520961F"));
        users.add(new User("Pablo","García", "pablo@gmail.com", new Date(), "", "Spain", "53520961F"));
        Factory factory = new Factory();
        ReportWriter reportWriter = factory.createDocxWriter();
        reportWriter.writeReport(users);
    }


    @Test
    public void testPdfWriter() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("Pablo","García", "pineirin@gmail.com", new Date(), "", "Spain", "53520961F"));
        users.add(new User("Pablo","García", "pablo@gmail.com", new Date(), "", "Spain", "53520961F"));
        Factory factory = new Factory();
        ReportWriter reportWriter = factory.createPdfWriter();
        reportWriter.writeReport(users);
    }



}