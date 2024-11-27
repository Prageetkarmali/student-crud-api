package com.trayo.student.Controller;

import com.trayo.student.Entity.Student;
import com.trayo.student.Service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/")
    @Operation(summary = "Create a new student", description = "Adds a new student to the database.")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student create = this.studentService.create(student);
        return new ResponseEntity<>(create, HttpStatus.CREATED);
    }

    @PutMapping("/{studentId}")
    @Operation(summary = "Update student details", description = "Updates an existing student's details by ID.")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable Integer studentId) {
        Student updated = this.studentService.update(student, studentId);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/")
    @Operation(summary = "Get all students", description = "Fetches the list of all students.")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> all = this.studentService.getAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{studentId}")
    @Operation(summary = "Get student by ID", description = "Fetches a student's details by their ID.")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer studentId) {
        Student studentById = this.studentService.getById(studentId);
        return ResponseEntity.ok(studentById);
    }

    @DeleteMapping("/{studentId}")
    @Operation(summary = "Delete student", description = "Deletes a student record by ID.")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer studentId) {
        this.studentService.deleteStudent(studentId);
        return ResponseEntity.ok("Student with ID " + studentId + " has been deleted successfully.");
    }
}
