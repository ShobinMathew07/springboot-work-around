package com.college.sngce.service;

import com.college.sngce.dto.TeacherDto;
import com.college.sngce.entity.Subject;
import com.college.sngce.entity.Teacher;
import com.college.sngce.exception.ResourceNotFoundException;
import com.college.sngce.repo.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherRepository repository;

    @Override
    public TeacherDto save(TeacherDto teacherDto) {
        Teacher teacher = new Teacher();
        teacher.setId(teacher.getId());
        teacher.setFirstName(teacherDto.getFirstName());
        teacher.setLastName(teacherDto.getLastName());
        if (teacherDto.getSubjects() != null)
            teacher.setSubject(teacherDto.getSubjects().stream().map(Subject::new).collect(Collectors.toList()));
        Teacher teacherResult = repository.save(teacher);
        teacherDto.setId(teacherResult.getId());
        return teacherDto;
    }

    @Override
    public List<TeacherDto> teachers() {
        return repository.findAll(Pageable.unpaged()).map(TeacherDto::new)
                .getContent();
    }

    @Override
    public TeacherDto teacher(long teacherId) {
        return null;
    }

    @Override
    public void deleteTeacher(long teacherId) {
        repository.findById(teacherId).map(item ->{
            repository.deleteById(teacherId);
            return true;
        }).orElseThrow( () ->new ResourceNotFoundException("Not Found"));

    }

    @Override
    public TeacherDto updateTeacher(TeacherDto teacher) {
        return null;
    }
}
