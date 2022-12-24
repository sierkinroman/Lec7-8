package dev.profitsoft.intern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class Lec78Application {

    public static void main(String[] args) {
        SpringApplication.run(Lec78Application.class, args);
    }

}
