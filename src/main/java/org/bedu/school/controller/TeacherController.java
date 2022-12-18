package org.bedu.school.controller;

import lombok.extern.slf4j.Slf4j;
import org.bedu.school.dto.TeacherDTO;
import org.bedu.school.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/teachers")
public class TeacherController {
    private ITeacherService service;

    @Autowired
    public TeacherController(ITeacherService service){
        this.service = service;
    }
    /**
     * The function is a GET request that returns a list of TeacherDTO objects
     *
     * @return A list of TeacherDTO objects
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TeacherDTO> findAll(){
        log.info("TeacherController - Method findAll");
        return service.findAll();
    }

    // A GET request that returns a list of TeacherDTO objects.
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<TeacherDTO> findById(@PathVariable("id")Long teacher_id)throws Exception{
        log.info("TeacherController - Method findById");
        return service.findById(teacher_id);
    }


    /**
     * The function is a POST request that returns a TeacherDTO object
     *
     * @param data The object that will be saved in the database.
     * @return TeacherDTO
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeacherDTO save(@RequestBody TeacherDTO data){
        log.info("TeacherController - Method save");
        return service.save(data);
    }

    // Updating the teacher's information.
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id")Long teacher_id, @RequestBody TeacherDTO data) throws Exception{
        log.info("TeacherController - Method update");
        service.update(teacher_id, data);
    }

    /**
     * The function deletes a teacher from the database by the teacher's id
     *
     * @param teacher_id The id of the teacher to be deleted.
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id")Long teacher_id) throws Exception{
        log.info("TeacherController - Method delete");
        service.delete(teacher_id);
    }
}