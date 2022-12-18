package org.bedu.school.service.impl;

import org.bedu.school.dto.StudentDTO;
import org.bedu.school.entity.Student;
import org.bedu.school.mapper.IStudentMapper;
import org.bedu.school.repository.IStudentRepository;
import org.bedu.school.service.IStudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {

    private IStudentMapper mapper;
    private IStudentRepository repository;

    public StudentServiceImpl(IStudentMapper mapper, IStudentRepository repository){
        this.mapper = mapper;
        this.repository = repository;
    }

    public List<StudentDTO> findAll(){
        List<Student> students = repository.findAll();
        return students.stream().map(mapper::toDTO).toList();
    }

    public List<StudentDTO> findById(Long student_id) throws Exception {
        Optional<Student> student = repository.findById(student_id);
        if(student.isPresent()) {
            return student.stream().map(mapper::toDTO).toList();
        }else {
            throw new Exception("Student not registered!");
        }
    }
    public StudentDTO save(StudentDTO data){
        Student entity = mapper.toEntity(data);
        return mapper.toDTO(repository.save(entity));
    }

    public void update(Long student_id, StudentDTO data) throws Exception{
        Optional<Student> result = repository.findById(student_id);
        if (result.isEmpty()){
            throw new Exception("Student not registered!");
        }
        Student student = result.get();
        student.setName(data.getName());
        repository.save(student);
    }
    public void delete(Long student_id) throws Exception{
        Optional<Student> result = repository.findById(student_id);
        if (result.isEmpty()){
            throw new Exception("Student not registered");
        }
        repository.deleteById(student_id);
    }
}
