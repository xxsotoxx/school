package org.bedu.school.mapper;

import org.bedu.school.dto.StudentDTO;
import org.bedu.school.entity.Student;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface IStudentMapper {
    StudentDTO toDTO(Student data);
    Student toEntity(StudentDTO data);
}
