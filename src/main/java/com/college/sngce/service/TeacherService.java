package com.college.sngce.service;

import com.college.sngce.dto.TeacherDto;

import java.util.List;

public interface TeacherService {
    TeacherDto save(TeacherDto teacher);

    List<TeacherDto> teachers();

    TeacherDto teacher(long teacherId);

    void deleteTeacher(long teacherId);

    TeacherDto updateTeacher(TeacherDto teacher);

}
