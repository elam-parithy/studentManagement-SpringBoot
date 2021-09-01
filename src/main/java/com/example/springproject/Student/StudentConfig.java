package com.example.springproject.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository respo) {
        return args -> {
            Student stu = new Student(
                    "lam",
                    "elam@gmail.com",
                    LocalDate.of(2000,Month.JANUARY,5)
            );

            Student stu2 = new Student(
                    "parithy",
                    "parithy@gmail.com",
                    LocalDate.of(2002,Month.MAY,2)
            );
        respo.saveAll(
                List.of(stu,stu2)
        );
        };
    }
}
