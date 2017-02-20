package main.asw.report;

import main.asw.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @author Pineirin
 * @since 14/02/2017.
 */
class TxtWriter implements ReportWriter {

    private final static Logger log = LoggerFactory.getLogger(TxtWriter.class);

    @Override
    public void writeReport(List<User> users) {
        BufferedWriter bufferedWriter = null;
        FileWriter fileWriter = null;
        for (User user : users)
            try {
                fileWriter = new FileWriter("..\\citizensLoader_i2b\\Generated\\GeneratedTxt\\" + user.getEmail() + ".txt");
                bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write("Greetings: " + user.getFirstName() + " " + user.getLastName() + ".\n"
                        + "This is your personal information that we have received: \n"
                        + "Date of birth: " + user.getDateOfBirth() + ".\n"
                        + "NIF: " + user.getNif() + ".\n"
                        + "Nationality: " + user.getNationality() + ".\n"
                        + "Addres: " + user.getAddress() + ".\n"
                        + "\n"
                        + "Your password is: " + user.getUnencryptedPass() + ".");
                log.info("Exported correctly to txt format");
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            } finally {
                try {
                    assert bufferedWriter != null;
                    bufferedWriter.close();
                    fileWriter.close();
                } catch (IOException ex) {
                    log.error(ex.getMessage(), ex);
                }
            }
    }
}
