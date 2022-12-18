package org.bedu.school.mapper;

import org.bedu.school.dto.CourseDTO;
import org.bedu.school.entity.Course;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ICourseMapper {
    CourseDTO toDTO(Course data);
    Course toEntity(CourseDTO data);

}
