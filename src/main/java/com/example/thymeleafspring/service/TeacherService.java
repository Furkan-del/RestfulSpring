package com.example.thymeleafspring.service;

import com.example.thymeleafspring.dto.EmployeeDto;
import com.example.thymeleafspring.dto.TeacherDto;
import com.example.thymeleafspring.entity.TeacherEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface TeacherService {



    public TeacherDto saveTeacher(TeacherDto teacherDto);

    public List<TeacherDto> getAllTeachers();

    public ResponseEntity<TeacherDto> getTeacherById(Long id );

    public ResponseEntity<TeacherDto> updateTeacher(Long id, TeacherDto teacherDto);

    public String deleteById(Long id);

    public TeacherDto entityToDto(TeacherEntity teacherEntity);

    public TeacherEntity dtoToEntity(TeacherDto dto);



}
