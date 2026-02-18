package fip.challenge_3.schooling_system.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student extends Person {

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id", nullable = false)
    private Department courseOfStudy;

    @ManyToMany(mappedBy = "students",fetch = FetchType.LAZY)
    private Set<Course> enrolledCourse = new HashSet<>();

    @Column(nullable = false)
    private Integer level;

    @Column(nullable = false)
    private BigDecimal cgpa;

    @Column(nullable = false)
    private LocalDateTime sessionAdmitted;
}
