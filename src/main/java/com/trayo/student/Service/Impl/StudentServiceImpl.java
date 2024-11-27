package com.trayo.student.Service.Impl;

import com.trayo.student.Entity.Student;
import com.trayo.student.Exception.ResourceNotFoundException;
import com.trayo.student.Repository.StudentRepository;
import com.trayo.student.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student create(Student student) {
        Student saved = this.studentRepository.save(student);
        return saved;
    }

    @Override
    public Student update(Student student, Integer studentId) {
        Student student1 = this.studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("student", "studentId", studentId));
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setEmail(student.getEmail());
        student1.setPassword(student.getPassword());
        student1.setAddress(student.getAddress());
        student1.setDateOfBirth(student.getDateOfBirth());
        Student update = this.studentRepository.save(student1);
        return update;
    }

    @Override
    public List<Student> getAll() {
        return this.studentRepository.findAll();
    }

    @Override
    public Student getById(Integer studentId) {
        Student student = this.studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("student", "studentId", studentId));
        return student;
    }

    @Override
    public void deleteStudent(Integer studentId) {
        Student student = this.studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("student", "studentId", studentId));
         this.studentRepository.delete(student);
    }
}
