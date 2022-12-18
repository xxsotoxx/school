package org.bedu.school.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long course_id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "credits",nullable = false)
    private int credits;

    @ManyToMany(mappedBy = "courseSet")
    Set<Teacher> teacherSet;

    @ManyToMany(mappedBy = "courseSet")
    Set<Student> studentSet;

}
