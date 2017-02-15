package main.asw;

import main.asw.repository.UserRepository;
import main.asw.user.User;
import main.asw.parser.Parser;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * Main application
 *
 * @author Labra
 * @author MIGUEL
 */
@SpringBootApplication
public class LoadUsers implements CommandLineRunner {

    private final static Logger log = LoggerFactory.getLogger(LoadUsers.class);

    @SuppressWarnings("SpringAutowiredFieldsWarningInspection")
    @Autowired
    private UserRepository repository;

    public static void main(String... args) {
        SpringApplication.run(LoadUsers.class, args);
    }


    public void run(String... args) {
        log.info("Running");
        if (args.length == 1) {
            try {
                Parser parser = new Parser(args[0]);
                List<User> users = parser.loadData();
                for (User user : users) {
                    //System.out.println(user);
                    repository.save(user);
                }
            } catch (IOException | ParseException e) {
                log.error(e.getMessage(), e);
            }
        }
    }
}
