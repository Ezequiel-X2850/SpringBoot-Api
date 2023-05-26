package com.PrimeraAppSpring.primerProyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstProjectApplication {

    public String PORT = System.getenv("jdbc:mysql://uwzqkn5lkxbsm9co:8WQP4PYCDO1pjRBzrIOZ@bxx3q63s3qwldpqwlony-mysql.services.clever-cloud.com:3306/bxx3q63s3qwldpqwlony");
  
    public static void main(String[] args) {
            SpringApplication.run(FirstProjectApplication.class, args);
    }

}
