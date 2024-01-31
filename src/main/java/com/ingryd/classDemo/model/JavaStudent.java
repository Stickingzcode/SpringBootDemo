package com.ingryd.classDemo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@Entity
@Table(name = "java_student")
public class JavaStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "First name can not be null")
    @NotBlank(message = "First name can not be blank")
    @Length(min = 3, message = "Name can not be less than three characters")
    @Column(name = "first_name")
    private String firstName;
    @NotNull(message = "Last name can not be null")
    @NotBlank(message = "Last name can not be blank")
    @Length(min = 3, message = "Name can not be less than three characters")
    @Column(name = "last_name")
    private String lastName;
    @NotNull(message = "Gender can not be null")
    @NotBlank(message = "Gender can not be blank")
    @Length(min = 4, message = "Name can not be less than three characters")
    private String sex;
    @NotNull
    @Min(value = 18, message = "You must be 18 years and above")
    @Max(value = 70, message = "Your age must be within the range of 18 and 70")
    private int age;
    @Email(message = "Please enter a valid email address")
    private String email;
    @Pattern(regexp = "Java[0-9]{4}", message = "Please follow the course naming convention")
    private String course;
    @Column(name = "phone_number")
    @Pattern(regexp = "[0-9]{11}")
    private String phoneNumber;
    public JavaStudent(){
    }
    public JavaStudent(String firstName, String lastName, String sex, int age, String email, String course, String phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.age = age;
        this.email = email;
        this.course = course;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   }
