package com.project.holyvacation.controller;

import com.project.holyvacation.domain.Vacation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class VacationController {

    @GetMapping("/vacations")
    public ResponseEntity<List<Vacation>> getVacations() {
        return null;
    }

    @PostMapping("/vacation")
    public ResponseEntity<?> createVacation(@RequestBody Vacation vacation) {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/vacation/{id}")
    public ResponseEntity<?> updateVacation(@PathVariable("id") long id) {
        return null;
    }
}
