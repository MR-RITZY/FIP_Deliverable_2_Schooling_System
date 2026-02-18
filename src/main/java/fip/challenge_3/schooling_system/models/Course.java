package fip.challenge_3.schooling_system.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"title", "department_id"}, name = "title_department_uk")})
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String title;

    @Column(unique = true, nullable = false)
    private String courseCode;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "courses_students_table",
            joinColumns = @JoinColumn(name = "course_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "student_id", nullable = false))
    private Set<Student> students = new HashSet<>();


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "courses_academicStaff_table",
            joinColumns = @JoinColumn(name = "course_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "academicStaff_id", nullable = false))
    private Set<AcademicStaff> academicStaffs = new HashSet<>();


}
