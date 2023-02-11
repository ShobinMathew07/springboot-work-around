package com.college.sngce.dto;

import com.college.sngce.entity.Subject;
import lombok.*;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Accessors(fluent = true)
@Getter
@Setter
@AllArgsConstructor
public class SubjectDto {

    private @NonNull long id;
    private @NonNull String name;

    public SubjectDto(Subject subject) {
        this.id = subject.getId();
        this.name = subject.getSubjectName();
    }
}
