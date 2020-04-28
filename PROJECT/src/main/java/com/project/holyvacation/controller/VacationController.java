package com.project.holyvacation.controller;

import com.project.holyvacation.domain.Vacation;
import com.project.holyvacation.dto.VacationDTO;
import com.project.holyvacation.service.VacationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class VacationController {
    private final VacationService vacationService;


    @GetMapping("/public-vacations")
    public ResponseEntity<List<VacationDTO>> getPublicVacations() {
        List<VacationDTO> vacations = vacationService.getPublicVacations();
        return vacations!=null && !vacations.isEmpty()
                ? new ResponseEntity<>(vacations, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    // ПОМЕНЯТЬ НА PRINCIPAL в дальнейшем
    @GetMapping("/vacations/{username}")
    public ResponseEntity<List<VacationDTO>> getVacations(@PathVariable String username) {
        List<VacationDTO> vacations = vacationService.getVacations(username);
        return vacations!=null && !vacations.isEmpty()
                ? new ResponseEntity<>(vacations, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/vacations")
    public ResponseEntity<?> createVacation(@RequestBody VacationDTO vacationDTO) {
        vacationService.save(vacationDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/vacations/{id}")
    public ResponseEntity<?> updateVacation(@PathVariable("id") long id) {
        return null;
    }
}
