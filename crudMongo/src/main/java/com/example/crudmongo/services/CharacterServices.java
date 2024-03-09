package com.example.crudmongo.services;

import com.example.crudmongo.models.Character;
import com.example.crudmongo.repositories.CharacterRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CharacterServices {

    @Autowired
    private  CharacterRepositories repository;

    @Autowired
    private MongoRepository mongo;

    public List<Character> findAll() {
        return repository.findAll();
    }

    public List<Character> findByNameContains(String name) {
        return repository.FindByNameContains(name);
    }

    public void saveCharacter(Character request){

        repository.save(request);
    }

    public void deleteCharacter(String id){
        repository.deleteById(id);
    }
}
