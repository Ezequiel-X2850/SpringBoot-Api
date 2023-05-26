package com.PrimeraAppSpring.primerProyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstProjectApplication {

    public String URL = System.getenv("DB_URL");
    public String USERNAME = System.getenv("DB_USERNAME");
    public String PASSWORD = System.getenv("DB_PASSWORD");
  
    public static void main(String[] args) {
            SpringApplication.run(FirstProjectApplication.class, args);
    }

}
