package org.bedu.school.service.impl;

import org.bedu.school.dto.TeacherDTO;
import org.bedu.school.entity.Teacher;
import org.bedu.school.mapper.ITeacherMapper;
import org.bedu.school.repository.ITeacherRepository;
import org.bedu.school.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements ITeacherService {

    private ITeacherMapper mapper;
    private ITeacherRepository repository;

    @Autowired
    public TeacherServiceImpl(ITeacherMapper mapper, ITeacherRepository repository){
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<TeacherDTO> findAll(){
        List<Teacher> teachers = repository.findAll();
        return teachers.stream().map(mapper::toDTO).toList();
    }

    public List<TeacherDTO> findById(Long teacher_id) throws Exception {
        Optional<Teacher> teacher = repository.findById(teacher_id);
        if(teacher.isPresent()) {
            return teacher.stream().map(mapper::toDTO).toList();
        }else {
            throw new Exception("Teacher not registered!");
        }
    }

    public TeacherDTO save(TeacherDTO data){
        Teacher entity = mapper.toEntity(data);
        return mapper.toDTO(repository.save(entity));
    }

    public void update(Long teacher_id, TeacherDTO data) throws Exception {
        Optional<Teacher> result = repository.findById(teacher_id);
        if (result.isEmpty()){
            throw new Exception("Teacher not registered!");
        }
        Teacher teacher = result.get();
        teacher.setName(data.getName());
        repository.save(teacher);
    }
    public void delete(Long teacher_id) throws Exception{
        Optional<Teacher> result = repository.findById(teacher_id);
        if (result.isEmpty()){
            throw new Exception("Teacher not registered!");
        }
        repository.deleteById(teacher_id);
    }

}
