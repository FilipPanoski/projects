package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "config")
public class MovieFinderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieFinderApplication.class, args);
    }
}
