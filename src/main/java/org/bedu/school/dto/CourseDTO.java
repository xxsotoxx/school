package org.bedu.school.dto;

import lombok.Data;

@Data
public class CourseDTO {
    private Long course_id;
    private String name;
    private int credits;
}
