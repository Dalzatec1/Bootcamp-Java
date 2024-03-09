package com.example.crudmongo.repositories;

import com.example.crudmongo.models.Character;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepositories extends MongoRepository<Character, String> {
    List<Character> FindByNameContains(String name);
}
