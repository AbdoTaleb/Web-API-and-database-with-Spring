package com.example.movies.controllers;


import com.example.movies.model.Character;
import com.example.movies.repositories.CharacterRepository;
import com.example.movies.services.CharacterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.util.Collection;


@RestController
@RequestMapping(path = "api/v1/characters")
public class CharacterController {
    private final CharacterService characterService;
    private final CharacterRepository characterRepository;

    public CharacterController(CharacterService characterService, CharacterRepository characterRepository) {
        this.characterService = characterService;
        this.characterRepository = characterRepository;
    }

    @Operation(summary = "Get all characters")
    @GetMapping // GET: localhost:8080/api/v1/characters
    public ResponseEntity<Collection<Character>> getAll() {
        return ResponseEntity.ok(characterService.findAll());
    }


    @Operation(summary = "Get a character by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Character.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "Character does not exist with supplied ID",
                    content = @Content)
    })
    @GetMapping("{id}") // GET: localhost:8080/api/v1/characters/1
    public ResponseEntity<Character> getById(@PathVariable int id) {
        if(characterRepository.existsById(id)){
            return ResponseEntity.ok(characterService.findById(id));
        }
        return ResponseEntity.noContent().build();
    }




    @Operation(summary = "Add a new character")
    @PostMapping // POST: localhost:8080/api/v1/characters
    public ResponseEntity add(@RequestBody Character characterToAdd) {
        Character character = characterService.add(characterToAdd);
        URI location = URI.create("characters/" + character.getId());
        return ResponseEntity.created(location).build();
        // return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @Operation(summary = "Update a character")
    @PutMapping("{id}") // PUT: localhost:8080/api/v1/characters/1
    public ResponseEntity update(@RequestBody Character character, @PathVariable int id) {
        // Validates if body is correct
        if(id != character.getId())
            return ResponseEntity.badRequest().build();
        characterService.update(character);
        return ResponseEntity.noContent().build();
    }
    @Operation(summary = "Deleting a character by its ID")
    @DeleteMapping("{id}") // DELETE: localhost:8080/api/v1/characters/1
    public ResponseEntity delete(@PathVariable int id) {
        characterService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @Operation(summary = "Search for a character")
    @GetMapping("search") // GET: localhost:8080/api/v1/characters/search?name=Ola
    public ResponseEntity<Collection<Character>> findByName(@RequestParam String name) {
        return ResponseEntity.ok(characterRepository.findAllByName(name));
    }

}
