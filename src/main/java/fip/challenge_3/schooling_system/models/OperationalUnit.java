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
public class OperationalUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "operationalUnit")
    private List<OperationalRole> operationalRole;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "school_id", nullable = false)
    private School school;

}
