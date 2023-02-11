package com.college.sngce.dto;


import com.college.sngce.entity.Teacher;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto implements Serializable {

    private @NonNull long id;
    private @NonNull String firstName;
    private @NonNull String lastName;
    @JsonIgnore
    private List<SubjectDto> subjects;


    public TeacherDto(Teacher teacher) {
        this.id = teacher.getId();
        this.firstName = teacher.getFirstName();
        this.lastName = teacher.getLastName();
        if(teacher.getSubject()!=null)
        this.subjects = teacher.getSubject().stream().map(SubjectDto::new).collect(Collectors.toList());
    }
}
