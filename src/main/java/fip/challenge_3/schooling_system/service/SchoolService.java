package fip.challenge_3.schooling_system.service;

import fip.challenge_3.schooling_system.dto.SchoolDto;
import fip.challenge_3.schooling_system.exceptions.ResourceAlreadyExistsException;
import fip.challenge_3.schooling_system.exceptions.ResourceNotFoundException;
import fip.challenge_3.schooling_system.models.School;
import fip.challenge_3.schooling_system.repo.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository schoolRepo;

    public SchoolDto getSchool(Long id) {
        School school = schoolRepo.findById(id).
                orElseThrow(() ->
                        new ResourceNotFoundException("School with id " + id + " not found"));

        return new SchoolDto(
                school.getId(),
                school.getName(),
                school.getAddress(),
                school.getLga(),
                school.getRegistrationID(),
                school.getDoe());
    }



    public List<SchoolDto> getAllSchool() {
        List<School> schools = schoolRepo.findAll();

        return schools.stream().map(school -> new SchoolDto(
                school.getId(),
                school.getName(),
                school.getAddress(),
                school.getLga(),
                school.getRegistrationID(),
                school.getDoe())).collect(Collectors.toList());
    }


    public SchoolDto registerSchool(SchoolDto schoolDto) {



        if(schoolRepo.existsByNameIgnoreCaseAndLgaIgnoreCase(schoolDto.name(), schoolDto.lga())) {
            throw new ResourceAlreadyExistsException(
                    "School with name " + schoolDto.name() + " already exists in " + schoolDto.lga() + "LGA");

        }
        School school = schoolRepo.save(new School(
                schoolDto.name(),
                schoolDto.address(),
                schoolDto.lga(),
                schoolDto.registrationID(),
                schoolDto.doe()
        ));


        return new SchoolDto(
                school.getId(),
                school.getName(),
                school.getAddress(),
                school.getLga(),
                school.getRegistrationID(),
                school.getDoe());


    }

    public void updateSchool(Long id, String name) {
        schoolRepo.findById(id).ifPresentOrElse(schl -> {

            if (schoolRepo.existsByNameIgnoreCaseAndLgaIgnoreCase(name, schl.getLga())){
                throw new ResourceAlreadyExistsException(
                        "School with name " + name + " already exists in " + schl.getLga() + "LGA");}
            schl.setName(name);
            schoolRepo.save(schl);},

                () -> {throw new ResourceNotFoundException("School Not Found");});

    }

    public void deleteSchool(Long id) {
        schoolRepo.findById(id).ifPresentOrElse(schoolRepo::delete, () -> {throw new ResourceNotFoundException("School Not Found");});

    }
}
