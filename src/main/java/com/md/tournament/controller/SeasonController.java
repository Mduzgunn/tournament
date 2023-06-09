package com.md.tournament.controller;

import com.md.tournament.dto.SeasonDTO;
import com.md.tournament.dto.requests.SeasonCreateRequest;
import com.md.tournament.dto.requests.SeasonUpdateRequest;
import com.md.tournament.service.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/seasons")
@CrossOrigin(origins = "*")
public class SeasonController {
    private final SeasonService seasonService;

    public SeasonController(SeasonService seasonService) {
        this.seasonService = seasonService;
    }

    @PostMapping
    public ResponseEntity<SeasonDTO> createSeason(@RequestBody SeasonCreateRequest request) {
        SeasonDTO createdSeason = seasonService.createSeason(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSeason);
    }

    @GetMapping
    public ResponseEntity<List<SeasonDTO>> getAllSeasons() {
        List<SeasonDTO> seasonDtoList = seasonService.getAllSeasonDtoList();
        return ResponseEntity.ok(seasonDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeasonDTO> getSeasonById(@PathVariable Long id) {
        SeasonDTO seasonDto = seasonService.getSeasonById(id);
        return ResponseEntity.ok(seasonDto);
    }

    @PutMapping
    public ResponseEntity<SeasonDTO> updateSeason(@RequestBody SeasonUpdateRequest request) {
        SeasonDTO updatedSeason = seasonService.updateSeason(request);
        return ResponseEntity.ok(updatedSeason);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSeason(@PathVariable Long id) {
        return ResponseEntity.ok(seasonService.deleteSeasonById(id));
    }
}
