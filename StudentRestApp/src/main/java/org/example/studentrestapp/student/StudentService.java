package org.example.studentrestapp.student;

import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student>studentByEmail = studentRepository
                .findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent()) {
            throw new IllegalStateException("Email already taken!");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exist= studentRepository.existsById(studentId);
        if (!exist) {
            throw new IllegalStateException("Student does not exist!");
        }

        studentRepository.deleteById(studentId);
    }
    @Transactional
    public void updateStudent(Long studentId, String name, String email) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("Student does not exist!"));
        if (name != null && name.length() >0 && !Objects.equals(student.getName(),name)) {
            student.setName(name);
        }
        if (email != null && email.length() >0 && !Objects.equals(student.getEmail(),email)) {
            Optional<Student>studentByEmail = studentRepository
                    .findStudentByEmail(student.getEmail());
            if (studentByEmail.isPresent()) {
                throw new IllegalStateException("Email already taken!");
            }
            student.setEmail(email);
        }


    }
}
