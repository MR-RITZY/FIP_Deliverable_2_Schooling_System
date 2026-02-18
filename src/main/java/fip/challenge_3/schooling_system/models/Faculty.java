package fip.challenge_3.schooling_system.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long Id;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "faculty", fetch = FetchType.LAZY)
    private Set<Department> department;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "school_id", nullable = false)
    private School school;

}
