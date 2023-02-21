package com.example.thymeleafspring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;

@Entity
@Data
@Log4j2
@NoArgsConstructor
@AllArgsConstructor
@Table(name="teachers")
public class TeacherEntity extends BaseEntity implements Serializable {

    @Column(name="First Name")
    private String firstName;

    @Column(name="First Name")
    private String lastName;

    @Column(name="Teacher ID")
    private Long teacherId;

    @Column(name="Master Student")
    private  String mentorofTeacher;



}
