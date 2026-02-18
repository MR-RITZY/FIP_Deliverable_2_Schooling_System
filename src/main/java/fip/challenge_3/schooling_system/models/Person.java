package fip.challenge_3.schooling_system.models;

import fip.challenge_3.schooling_system.enums.Gender;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;



@MappedSuperclass
@Getter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = false)
    protected String firstName;

    @Column(nullable = false)
    protected String lastName;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    protected Gender gender;

    @Column(nullable = false)
    protected LocalDateTime dob;


}
