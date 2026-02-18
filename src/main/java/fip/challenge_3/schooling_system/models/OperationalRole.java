package fip.challenge_3.schooling_system.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"role", "unit_id"}, name = "role_unit_uk")})
public class OperationalRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String role;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "unit_id", nullable = false)
    private OperationalUnit  operationalUnit;

    @OneToMany(mappedBy = "operationalRole")
    private List<NonAcademicStaff> nonAcademicStaffs;


}
