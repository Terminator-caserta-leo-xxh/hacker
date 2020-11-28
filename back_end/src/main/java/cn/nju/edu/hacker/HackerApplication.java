package cn.nju.edu.hacker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class HackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HackerApplication.class, args);
    }

}
