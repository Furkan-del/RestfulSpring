package com.example.thymeleafspring.uirest;

import com.example.thymeleafspring.dto.TeacherDto;
import com.example.thymeleafspring.servicesimpl.TeacherServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
@RequestMapping("api/v2")
public class TeacherController {
    private final TeacherServiceImpl teacherService;


    @PostMapping("save")
    public TeacherDto saveTeacher(@RequestBody TeacherDto teacherDto) {
        teacherService.saveTeacher(teacherDto);
        return teacherDto;
    }

    @GetMapping("/teachers")
    public List<TeacherDto> getAllTeachers() {
        return teacherService.getAllTeachers();

    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable(name="id")Long id){
       return  teacherService.deleteById(id);

    }
    @PutMapping("/teachers/{id}")
    public ResponseEntity<TeacherDto> getTeacherById(@PathVariable(name="id" )Long id,@RequestBody TeacherDto teacherDto){
        teacherService.updateTeacher(id,teacherDto);
        return  ResponseEntity.ok(teacherDto);
    }

}
