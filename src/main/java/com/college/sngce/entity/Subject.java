package com.college.sngce.entity;

import com.college.sngce.dto.SubjectDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Table (name = "subject")
@Getter
@Setter
@AllArgsConstructor
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    private String subjectName;

    public Subject(SubjectDto dto) {
        this.id = dto.id();
        this.setSubjectName(dto.name());
    }



}
