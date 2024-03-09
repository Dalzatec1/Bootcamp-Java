package com.example.crudmongo.crontrollers;

import com.example.crudmongo.models.Character;
import com.example.crudmongo.services.CharacterServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/characters")
public class CharacterController {


        @Autowired
        private CharacterServices characterService;



    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Character> response = characterService.findAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{name}/name")
    public ResponseEntity<?> getByNameContains(@PathVariable String name){
        List<Character> response = characterService.findByNameContains(name);
    if(!response.isEmpty()){
        return ResponseEntity.ok(response);
        }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> createCharacter(@RequestBody Character request){
        characterService.saveCharacter(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<?> deleteCharacter(@PathVariable String id){
        characterService.deleteCharacter(id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}

