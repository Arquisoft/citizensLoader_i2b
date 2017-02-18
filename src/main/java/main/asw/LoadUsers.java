package main.asw;

import main.asw.repository.PersistenceFactory;
import main.asw.repository.UserDao;
import main.asw.user.User;
import main.asw.parser.impl.ParserImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.ParseException;

/**
 * Main application
 *
 * @author Labra
 * @author MIGUEL
 */

public class LoadUsers {

    private final static Logger log = LoggerFactory.getLogger(LoadUsers.class);

    public static void main(String... args) {

        UserDao ud = PersistenceFactory.getUserDAO();

        log.info("Running");
        if (args.length == 1) {
            try {
                ParserImpl parser = new ParserImpl(args[0]);
                parser.readList();
                for (User user : parser.getUsers()) {
                    //System.out.println(user);
                    ud.saveUser(user);
                }
            } catch (IOException | ParseException e) {
                log.error(e.getMessage(), e);
            }
        }
    }

}
