package fip.challenge_3.schooling_system.controller;

import fip.challenge_3.schooling_system.dto.SchoolDto;
import fip.challenge_3.schooling_system.service.SchoolService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schools")
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolService schoolService;

    @GetMapping("/{id}")
    public ResponseEntity<SchoolDto> getSchool(@RequestParam long id) {
        return ResponseEntity.ok(schoolService.getSchool(id));

    }

    @GetMapping("/")
    public ResponseEntity<List<SchoolDto>> getAllSchool() {
        return ResponseEntity.ok(schoolService.getAllSchool());

    }


    @PostMapping("/")
    public ResponseEntity<SchoolDto> registerSchool(@Valid @RequestBody SchoolDto schoolDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(schoolService.registerSchool(schoolDto));

    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updateSchoolData (@RequestParam Long id, @RequestBody String name) {
        schoolService.updateSchool(id, name);
        return ResponseEntity.ok("Updated");

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSchool (@RequestParam Long id) {
        schoolService.deleteSchool(id);
        return ResponseEntity.noContent().build();
    }



}
