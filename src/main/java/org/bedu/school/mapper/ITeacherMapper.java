package org.bedu.school.mapper;

import org.bedu.school.dto.TeacherDTO;
import org.bedu.school.entity.Teacher;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ITeacherMapper {
    TeacherDTO toDTO(Teacher data);
    Teacher toEntity(TeacherDTO data);

}
