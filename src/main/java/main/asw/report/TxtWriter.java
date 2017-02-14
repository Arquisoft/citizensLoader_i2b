package main.asw.report;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Pineirin on 14/02/2017.
 */
public class TxtWriter implements ReportWriter {

    private String nombreDocumento = "Documento.txt";

    @Override
    public void writeReport() {
        BufferedWriter bufferedWriter = null;
        FileWriter fileWriter = null;

        try {

            String content = "The document is Empty\n";

            fileWriter = new FileWriter(nombreDocumento);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(content);

            System.out.println("Done");

        } catch (IOException e) {

            e.printStackTrace();

        } finally {
            try {

                if (bufferedWriter != null)
                    bufferedWriter.close();

                if (fileWriter != null)
                    fileWriter.close();

            } catch (IOException ex) {

                ex.printStackTrace();
            }
        }
    }
}
