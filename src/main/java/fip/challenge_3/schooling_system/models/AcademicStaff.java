package fip.challenge_3.schooling_system.models;

import fip.challenge_3.schooling_system.enums.AcademicRank;
import fip.challenge_3.schooling_system.enums.LevelAtService;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AcademicStaff extends Person {

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AcademicRank academicRank;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LevelAtService level;

    @ManyToMany(mappedBy = "academicStaffs",fetch = FetchType.LAZY)
    private Set<Course> lecturingCourses = new HashSet<>();


}
