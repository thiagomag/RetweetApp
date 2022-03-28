package br.com.thiago.retweetbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RetweetBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(RetweetBotApplication.class, args);
    }

}
