package com.example.springproject.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRespository;

    @Autowired
    public StudentService(StudentRepository studentRespository) {
        this.studentRespository = studentRespository;
    }

    public List<Student> getStudents() {
        return studentRespository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRespository
                .findStudentByemail(student.getEmail());
        if(studentOptional.isPresent()) {
            throw new IllegalStateException("Email already taken");
        }
        studentRespository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRespository.existsById(studentId);

        if(!exists) {
            throw new IllegalStateException(
                    "student  with id " + studentId + " doex not exists"
            );
        }
        studentRespository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId,String name,String email) {
        Student student = studentRespository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id" + studentId + "doesn't Exist"
                ));
        if(name != null &&
                name. length()>0 &&
                !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }
    }
}
