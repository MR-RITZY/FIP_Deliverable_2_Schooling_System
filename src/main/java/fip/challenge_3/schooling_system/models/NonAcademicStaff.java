package fip.challenge_3.schooling_system.models;


import fip.challenge_3.schooling_system.enums.LevelAtService;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class NonAcademicStaff extends Person {


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", nullable = false)
    private OperationalRole operationalRole;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LevelAtService level;
}
