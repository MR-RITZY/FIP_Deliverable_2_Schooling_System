package fip.challenge_3.schooling_system.repo;

import fip.challenge_3.schooling_system.enums.LGA;
import fip.challenge_3.schooling_system.models.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SchoolRepository extends JpaRepository<School,Long> {
    boolean existsByNameIgnoreCaseAndLgaIgnoreCase(String name, LGA lga);

    Optional<School> findByIdAndName(Long id, String name);
}
