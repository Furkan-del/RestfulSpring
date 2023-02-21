package com.example.thymeleafspring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Data
@Log4j2
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherDto {
    private String firstName ;
    private String lastName;
    private Long teacherId;

}
