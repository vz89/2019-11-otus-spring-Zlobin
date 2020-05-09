package com.project.holyvacation.controller;

import com.project.holyvacation.domain.Vacation;
import com.project.holyvacation.dto.VacationDTO;
import com.project.holyvacation.dto.mapper.VacationMapper;
import com.project.holyvacation.service.VacationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class VacationController {
    private final VacationService vacationService;
    private final VacationMapper vacationMapper;


    @GetMapping("/api/public-vacations")
    public ResponseEntity<List<VacationDTO>> getPublicVacations() {
        List<VacationDTO> vacations = vacationService.getPublicVacations();
        return vacations != null && !vacations.isEmpty()
                ? new ResponseEntity<>(vacations, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/api/vacations")
    public ResponseEntity<List<VacationDTO>> getVacations(Principal principal) {
        List<VacationDTO> vacations = vacationService.getVacations(principal.getName());
        return vacations != null && !vacations.isEmpty()
                ? new ResponseEntity<>(vacations, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/api/vacations")
    public ResponseEntity<?> createVacation(@RequestBody VacationDTO vacationDTO, Principal principal) {
        vacationDTO.setUsername(principal.getName());
        vacationService.save(vacationDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PreAuthorize("principal.username == #vacation.user.username")
    @GetMapping("/api/vacations/{id}")
    public ResponseEntity<VacationDTO> getVacation(@PathVariable("id") Vacation vacation) {
        return new ResponseEntity<>(vacationMapper.toDTO(vacation), HttpStatus.OK);
    }

    @PreAuthorize("principal.username == #vacation.user.username")
    @PutMapping("/api/vacations/{id}")
    public ResponseEntity<?> updateVacation(@PathVariable("id") Vacation vacation, @RequestBody VacationDTO vacationDTO) {
        vacationService.update(vacation, vacationDTO);
        return new ResponseEntity<>("updated", HttpStatus.OK);
    }

    @PreAuthorize("principal.username == #vacation.user.username")
    @DeleteMapping("/api/vacations/{id}")
    public ResponseEntity<?> deleteVacation(@PathVariable("id") Vacation vacation) {
        vacationService.deleteById(vacation.getId());
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }
}
