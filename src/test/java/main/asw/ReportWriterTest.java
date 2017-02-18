package main.asw;

import main.asw.report.Factory;
import main.asw.report.ReportWriter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Pineirin on 18/02/2017.
 */
public class ReportWriterTest {
    @Test
    public void testTxtWriter() {
        Factory factory = new Factory();
        ReportWriter reportWriter = factory.createTxtWriter();
        reportWriter.writeReport("Primero.txt", "Adios");
    }

    @Test
    public void testDocxWriter() {
        Factory factory = new Factory();
        ReportWriter reportWriter = factory.createTxtWriter();
        reportWriter.writeReport("Segundo.docx", "Adios");
    }

    @Test
    public void testPdfWriter() {
        Factory factory = new Factory();
        ReportWriter reportWriter = factory.createTxtWriter();
        reportWriter.writeReport("Tercero.pdf", "Adios");
    }


}