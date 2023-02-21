package com.example.thymeleafspring.servicesimpl;

import com.example.thymeleafspring.dto.EmployeeDto;
import com.example.thymeleafspring.dto.TeacherDto;
import com.example.thymeleafspring.entity.EmployeeEntity;
import com.example.thymeleafspring.entity.TeacherEntity;
import com.example.thymeleafspring.exception.ResourceNotFoundException;
import com.example.thymeleafspring.repository.EmployeeRepository;
import com.example.thymeleafspring.repository.TeacherRepository;
import com.example.thymeleafspring.service.TeacherService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {


    private final ModelMapper modelMapper;

    private final TeacherRepository teacherRepository; // dbyle alakalı


    @Override
    public TeacherDto saveTeacher(TeacherDto teacherDto) {
        teacherRepository.save(dtoToEntity(teacherDto));
        return teacherDto;
    }

    @Override
    public List<TeacherDto> getAllTeachers() {
        Iterable<TeacherEntity> teacherEntities = teacherRepository.findAll();
        List<TeacherDto> teacherDtos = new ArrayList<>();
        for (TeacherEntity teacherEntity : teacherEntities) {
            TeacherDto teacherDto = entityToDto(teacherEntity);
            teacherDtos.add(teacherDto);
        }
        return teacherDtos;
    }

    @Override
    public ResponseEntity<TeacherDto> getTeacherById(@PathVariable(name = "id") Long id) {
        TeacherEntity teacherEntity = teacherRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("we didnt found this id" + id));
        TeacherDto teacherDto = entityToDto(teacherEntity);
        return ResponseEntity.ok(teacherDto);
    }

    @Override
    public ResponseEntity<TeacherDto> updateTeacher(@PathVariable(name="id") Long id, TeacherDto teacherDto) {
        TeacherEntity teacherEntity=teacherRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("we didnt found"+id));
        teacherEntity.setFirstName(teacherDto.getFirstName());
        teacherEntity.setLastName(teacherDto.getLastName());
        teacherEntity.setTeacherId(teacherDto.getTeacherId());
        return  ResponseEntity.ok(teacherDto);
    }

    @Override
    public String deleteById(@PathVariable(name = "id") Long id) {
        TeacherEntity teacherEntity = teacherRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("resource dont found"));
        teacherRepository.delete(teacherEntity);
      return "deleted";
    }

    @Override
    public TeacherDto entityToDto(TeacherEntity teacherEntity) {
        return  modelMapper.map(teacherEntity, TeacherDto.class);

    }

    @Override
    public TeacherEntity dtoToEntity(TeacherDto teacherDto) {
        return modelMapper.map(teacherDto, TeacherEntity.class);

    }


}
