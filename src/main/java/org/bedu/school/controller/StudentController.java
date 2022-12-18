package org.bedu.school.controller;

import lombok.extern.slf4j.Slf4j;
import org.bedu.school.dto.StudentDTO;
import org.bedu.school.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {
    private IStudentService service;

    @Autowired
    public StudentController(IStudentService service){
        this.service = service;
    }


    /**
     * The function is a GET request that returns a list of StudentDTO objects
     *
     * @return A list of StudentDTO objects
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StudentDTO> findAll(){
        log.info("StudentController - Method findAll");
        return service.findAll();
    }

    // A GET request that returns a list of StudentDTO objects
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentDTO> findById(@PathVariable("id")Long student_id)throws Exception{
        log.info("StudentController - Method findById");
        return service.findById(student_id);

    }

    /**
     * The function is a POST request that returns a StudentDTO object
     *
     * @param data The object that will be saved in the database.
     * @return StudentDTO
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDTO save(@RequestBody StudentDTO data){
        log.info("StudentController - Method save");
        return service.save(data);
    }

    /**
     * The function takes in a student id and a student data object, and updates the student with the given id with the
     * given data
     *
     * @param student_id The id of the student to be updated.
     * @param data The data that will be used to update the student.
     */
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id")Long student_id, @RequestBody StudentDTO data) throws Exception{
        log.info("StudentController - Method update");
        service.update(student_id, data);
    }
    /**
     * The function deletes a student from the database by the student's id
     *
     * @param student_id The id of the student to be deleted.
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id")Long student_id) throws Exception{
        log.info("StudentController - Method delete");
        service.delete(student_id);
    }
}
