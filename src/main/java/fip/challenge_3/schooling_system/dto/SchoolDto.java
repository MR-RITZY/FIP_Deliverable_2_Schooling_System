package fip.challenge_3.schooling_system.dto;

import fip.challenge_3.schooling_system.enums.LGA;

import java.time.LocalDate;


public record SchoolDto(
        Long id,
        String name,
        String address,
        LGA lga,
        String registrationID,
        LocalDate doe
) {
}
