package org.bedu.school.service.impl;

import org.bedu.school.dto.CourseDTO;
import org.bedu.school.entity.Course;
import org.bedu.school.mapper.ICourseMapper;
import org.bedu.school.repository.ICourseRepository;
import org.bedu.school.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements ICourseService {

    private ICourseMapper mapper;
    private ICourseRepository repository;

    @Autowired
    public CourseServiceImpl(ICourseMapper mapper, ICourseRepository repository){
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<CourseDTO> findAll(){
        List<Course> courses = repository.findAll();
        return courses.stream().map(mapper::toDTO).toList();
    }

    public List<CourseDTO> findById(Long course_id) throws Exception {
        Optional<Course> course = repository.findById(course_id);
        if(course.isPresent()) {
            return course.stream().map(mapper::toDTO).toList();
        }else {
            throw new Exception("Course doesn't exist!");
        }
    }

    public CourseDTO save(CourseDTO data){
        Course entity = mapper.toEntity(data);
        return mapper.toDTO(repository.save(entity));
    }

    public void update(Long course_id, CourseDTO data) throws Exception {
        Optional<Course> result = repository.findById(course_id);
        if (result.isEmpty()){
            throw new Exception("Course doesn't exist!");
        }
        Course course = result.get();
        course.setName(data.getName());
        course.setCredits(data.getCredits());
        repository.save(course);
    }
    public void delete(Long course_id) throws Exception{
        Optional<Course> result = repository.findById(course_id);
        if (result.isEmpty()){
            throw new Exception("Course doesn't exist!");
        }
        repository.deleteById(course_id);
    }

}
