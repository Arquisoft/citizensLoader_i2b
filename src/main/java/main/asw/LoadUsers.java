package main.asw;

import main.asw.user.User;
import main.asw.parser.Parser;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * Main application
 *
 * @author Labra
 * @author MIGUEL
 */

public class LoadUsers {

    private final static Logger log = LoggerFactory.getLogger(LoadUsers.class);

    //TODO conexion a la bd

    public static void main(String... args) {
    	log.info("Running");
        if (args.length == 1) {
            try {
                Parser parser = new Parser(args[0]);
                List<User> users = parser.loadData();
                for (User user : users) {
                    //System.out.println(user);
                    //repository.save(user);
                }
            } catch (IOException | ParseException e) {
                log.error(e.getMessage(), e);
            }
        }
    }

}
