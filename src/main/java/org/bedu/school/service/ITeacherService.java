package org.bedu.school.service;

import org.bedu.school.dto.TeacherDTO;

import java.util.List;

public interface ITeacherService {
    List<TeacherDTO> findAll();

    List<TeacherDTO> findById(Long teacher_id) throws Exception;

    TeacherDTO save(TeacherDTO data);

    void update(Long teacher_id, TeacherDTO data) throws Exception;

    void delete(Long teacher_id) throws Exception;
}
