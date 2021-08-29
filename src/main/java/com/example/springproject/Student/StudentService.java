package com.example.springproject.Student;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {
    public List<Student> getStudents() {

        return List.of(
                new Student(
                        1L,
                        "Elam",
                        "elam@gmail.com",
                        LocalDate.of(1998, Month.MAY,5),
                        21
                )

        );
    }
}
