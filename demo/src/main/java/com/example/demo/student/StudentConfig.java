package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student mariam = new Student(


                    "Kevin",
                    "mariam@gmail.com",
                    LocalDate.of(2000, Month.FEBRUARY,1)

            );
            Student kevin = new Student(

                    "Kevin",
                    "kevin@gmail.com",
                    LocalDate.of(2004, Month.DECEMBER,1)

            );
            repository.saveAll(
                    List.of(mariam,kevin)
            );

        };
    }
}
