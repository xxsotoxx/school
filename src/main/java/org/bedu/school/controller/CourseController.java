package org.bedu.school.controller;

import lombok.extern.slf4j.Slf4j;
import org.bedu.school.dto.CourseDTO;
import org.bedu.school.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/courses")
public class CourseController {
    private ICourseService service;

    @Autowired
    public CourseController(ICourseService service){
        this.service = service;
    }


    /**
     * The function is a GET request that returns a list of CourseDTO objects
     *
     * @return A list of CourseDTO objects
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CourseDTO> findAll(){
        log.info("CourseController - Method findAll");
        return service.findAll();
    }

    /**
     * This function is used to find a course by its id
     *
     * @param course_id The id of the course you want to find.
     * @return A list of courses
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<CourseDTO> findById(@PathVariable("id")Long course_id)throws Exception{
        log.info("CourseController - Method findById");
        return service.findById(course_id);
    }

    /**
     * The function is a POST request, it returns a status of CREATED, and it returns a CourseDTO object
     *
     * @param data The object that will be saved in the database.
     * @return A CourseDTO object
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseDTO save(@RequestBody CourseDTO data){
        log.info("CourseController - Method save");
        return service.save(data);
    }

    /**
     * It updates the course with the given id.
     *
     * @param course_id The id of the course to be updated.
     * @param data The data that will be used to update the course.
     */
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id")Long course_id, @RequestBody CourseDTO data) throws Exception{
        log.info("CourseController - Method update");
        service.update(course_id, data);
    }

    /**
     * The function deletes a course from the database by its id
     *
     * @param course_id The id of the course to be deleted.
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id")Long course_id) throws Exception{
        log.info("CourseController - Method delete");
        service.delete(course_id);
    }
}
