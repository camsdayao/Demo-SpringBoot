package com.student;

import java.lang.StackWalker.Option;
//import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PostMapping;

@Service
public class StudentService {

    private final StudentRepo studentRepo;

    // @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepo.findStudentByEmail(student.getEmail());
        studentRepo.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email Taken");
        }

        studentRepo.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exist = studentRepo.existsById(studentId);
        if (!exist) {
            throw new IllegalStateException("student id " + studentId + "doesnt not exist");
        }
        studentRepo.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("Student with " + studentId + "does not exist"));
        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }
        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            Optional<Student> studentOptional = studentRepo.findStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("Email taken");
            }
            student.setEmail(email);
        }
    }

}
