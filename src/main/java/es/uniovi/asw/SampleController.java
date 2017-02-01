package es.uniovi.asw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class SampleController implements CommandLineRunner {

    @Autowired
    private CitizenRepository repository;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }


    @Override
    public void run(String... strings) throws Exception {
        System.out.println("Run");
        repository.save(new Citizen("Jorge", "Lópezz"));
    }
}
