package es.uniovi.asw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by nokutu on 01/02/2017.
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    @SuppressWarnings("SpringAutowiredFieldsWarningInspection")
    @Autowired
    private CitizenRepository repository;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

        System.out.println("Run");
        repository.save(new Citizen("Jorge", "Lópezz"));
    }
}
