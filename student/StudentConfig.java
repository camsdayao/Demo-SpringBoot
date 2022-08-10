package com.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

        @Bean
        CommandLineRunner commandLineRunner(StudentRepo repo) {
                return args -> {
                        Student mariam = new Student(
                                        "Mariam", "mariam.jamal@gmail.com", LocalDate.of(1990, Month.JANUARY, 5));

                        Student alex = new Student(
                                        "Alex", "alex@gmail.com", LocalDate.of(1993, Month.NOVEMBER, 23));

                        Student bilal = new Student(
                                        "Bilal", "ahmed@gmail.com", LocalDate.of(1995, Month.DECEMBER, 17));

                        repo.saveAll(List.of(mariam, alex, bilal));

                };
        }
}
