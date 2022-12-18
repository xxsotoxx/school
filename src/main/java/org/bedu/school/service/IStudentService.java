package org.bedu.school.service;

import org.bedu.school.dto.StudentDTO;

import java.util.List;

public interface IStudentService {
    List<StudentDTO> findAll();

    List<StudentDTO> findById(Long student_id) throws Exception;

    StudentDTO save(StudentDTO data);

    void update(Long student_id, StudentDTO data) throws Exception;

    void delete(Long student_id) throws Exception;
}
