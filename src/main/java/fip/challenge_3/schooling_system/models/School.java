package fip.challenge_3.schooling_system.models;

import fip.challenge_3.schooling_system.enums.LGA;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"name", "lga"}, name = "lga_schoolname_uq"))
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String address;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LGA lga;

    @Column(unique = true, nullable = false)
    private String registrationID;

    @Column(nullable = false)
    private LocalDate doe;



    @OneToMany(mappedBy ="school", fetch=FetchType.LAZY)
    private Set<Faculty> faculties = new HashSet<>();


    @OneToMany(mappedBy ="school", fetch = FetchType.LAZY)
    private Set<OperationalUnit> operationalUnits = new HashSet<>();


    public School(String name,
                  String address,
                  LGA lga,
                  String registrationID,
                  LocalDate doe) {

        this.name = name;
        this.address = address;
        this.lga = lga;
        this.registrationID = registrationID;
        this.doe = doe;
    }
}