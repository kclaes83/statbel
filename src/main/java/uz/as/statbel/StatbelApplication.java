package uz.as.statbel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class StatbelApplication {

    public static void main(String[] args) {
        SpringApplication.run(StatbelApplication.class, args);
    }

}

