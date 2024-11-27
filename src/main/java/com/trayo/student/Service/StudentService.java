package com.trayo.student.Service;

import com.trayo.student.Entity.Student;

import java.util.List;

public interface StudentService {
    //create student
    Student create(Student student);
    //update student
    Student update(Student student,Integer studentId);
    //get all student
    List<Student> getAll();
    //get student by id
    Student getById(Integer studentId);
    //delete student
    void deleteStudent(Integer studentId);
}
