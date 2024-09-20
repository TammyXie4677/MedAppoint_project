package com.example.medappointdemo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String firstname;

    @Column(length = 100)
    private String lastname;

    @Column(length = 100, unique = true, nullable = false)
    @NotNull
    @Email
    private String email;

    @Column(length = 255, unique = true, nullable = false)
    @NotNull
    @Size(min = 6)
    private String password;

    @Transient
    private String confirmPassword;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(name = "avatar_url", length = 255)
    private String avatarUrl;

    @Column(length = 100)
    private String specialty;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(columnDefinition = "TEXT")
    private String address;
}
