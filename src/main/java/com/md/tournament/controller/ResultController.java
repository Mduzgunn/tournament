package com.md.tournament.controller;

import com.md.tournament.dto.ResultDTO;
import com.md.tournament.exception.ResultNotFoundException;
import com.md.tournament.model.Result;
import com.md.tournament.service.ResultService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/results")
@CrossOrigin(origins = "*")
public class ResultController {
    private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @PostMapping
    public ResponseEntity<Result> createResult(@RequestBody ResultDTO resultForm) {
        Result createdResult = resultService.create(resultForm);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdResult);
    }

    @GetMapping
    public ResponseEntity<List<Result>> getAllResults() {
        List<Result> resultDtoList = resultService.getAll();
        return ResponseEntity.ok(resultDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Result> getResultById(@PathVariable Long id) {
        Result result = resultService.get(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping
    public ResponseEntity<Result> updateResult(@RequestBody ResultDTO resultForm) throws ResultNotFoundException {
        Result updatedResult = resultService.update(resultForm);
        return ResponseEntity.ok(updatedResult);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResult(@PathVariable Long id) throws ResultNotFoundException {
        resultService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
