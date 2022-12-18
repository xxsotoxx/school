package org.bedu.school.service;

import org.bedu.school.dto.CourseDTO;

import java.util.List;

public interface ICourseService {
    List<CourseDTO> findAll();

    List<CourseDTO> findById(Long course_id) throws Exception;

    CourseDTO save(CourseDTO data);

    void update(Long course_id, CourseDTO data) throws Exception;

    void delete(Long course_id) throws Exception;
}
