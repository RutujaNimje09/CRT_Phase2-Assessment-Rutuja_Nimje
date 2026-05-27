package com.example.demo.Q3.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Q3.dto.StudentDTO;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @PostMapping
    public ResponseEntity<String> createStudent(
            @Valid @RequestBody StudentDTO studentDTO,
            BindingResult result) {

        if (result.hasErrors()) {
            String errorMessage = result.getAllErrors()
                    .get(0)
                    .getDefaultMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Student created successfully", HttpStatus.CREATED);
    }
}
