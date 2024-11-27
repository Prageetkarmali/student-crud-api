package com.trayo.student.Entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;
    @Column(name = "First_Name",nullable = false)
    private String firstName;
    @Column(name = "Last_Name",nullable = false)
    private String lastName;
    @Column(name = "Email_Address",nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String address;
    @Column(name = "DOB",nullable = false)
    private LocalDate dateOfBirth;
}
