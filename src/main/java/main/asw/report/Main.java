package main.asw.report;

/**
 * Created by Pineirin on 18/02/2017.
 */
public class Main {
    public static void main(String args[]){
        Factory factory = new Factory();
        ReportWriter reportWriter = factory.createTxtWriter();
        reportWriter.writeReport("Hola", "Adios");
    }
}
