package com.college.sngce.controller;

import com.college.sngce.dto.TeacherDto;
import com.college.sngce.entity.Teacher;
import com.college.sngce.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/staff")
public class StaffsController {

    @Autowired
    TeacherService service;

    @GetMapping
    public ResponseEntity<Page<Teacher>> getTeachers() {
        List<TeacherDto> teachers = service.teachers();
        if (teachers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity(teachers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Teacher> create(@RequestBody @Validated TeacherDto teacherDto) {
        TeacherDto teacher = service.save(teacherDto);
        if (teacher == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity(teacher, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<TeacherDto> delete(@RequestParam Long teacherId) {
        service.deleteTeacher(teacherId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
