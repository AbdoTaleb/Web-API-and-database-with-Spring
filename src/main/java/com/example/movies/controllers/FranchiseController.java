package com.example.movies.controllers;

import com.example.movies.model.Character;
import com.example.movies.model.Franchise;
import com.example.movies.repositories.FranchiseRepository;
import com.example.movies.services.FranchiseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping(path = "api/v1/franchises") // Base URL
public class FranchiseController {
    private final FranchiseService franchiseService;
    private final FranchiseRepository franchiseRepository;

    public FranchiseController(FranchiseService franchiseService, FranchiseRepository franchiseRepository) {
        this.franchiseService = franchiseService;
        this.franchiseRepository = franchiseRepository;
    }


    @GetMapping // GET: localhost:8080/api/v1/franchises
    public ResponseEntity<Collection<Franchise>> getAll() {
        return ResponseEntity.ok(franchiseService.findAll());
    }

    @GetMapping("{id}") // GET: localhost:8080/api/v1/franchises/1
    public ResponseEntity<Franchise> getById(@PathVariable int id) {
        return ResponseEntity.ok(franchiseService.findById(id));
    }

    @PostMapping // POST: localhost:8080/api/v1/franchises
    public ResponseEntity add(@RequestBody Franchise franchiseToAdd) {
        Franchise franchise = franchiseService.add(franchiseToAdd);
        URI location = URI.create("franchises/" + franchise.getId());
        return ResponseEntity.created(location).build();
        // return ResponseEntity.status(HttpStatus.CREATED).build();
    }

//    Body to add franchise
//    {
//        "name": "Name of franchise",
//        "description": "Some description"
//    }

    @PutMapping("{id}") // PUT: localhost:8080/api/v1/franchises/1
    public ResponseEntity update(@RequestBody Franchise franchise, @PathVariable int id) {
        // Validates if body is correct
        if(id != franchise.getId())
            return ResponseEntity.badRequest().build();
        franchiseService.update(franchise);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}") // DELETE: localhost:8080/api/v1/franchises/1
    public ResponseEntity delete(@PathVariable int id) {
        franchiseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("search") // GET: localhost:8080/api/v1/franchises/search?name=Ola
    public ResponseEntity<Collection<Franchise>> findByName(@RequestParam String name) {
        return ResponseEntity.ok(franchiseRepository.findAllByName(name));
    }

}
