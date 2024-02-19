package com.demosql.demo.controllers;

import com.demosql.demo.dtos.UserDto;
import com.demosql.demo.models.User;
import com.demosql.demo.repositories.UsersRepository;
import com.demosql.demo.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import com.demosql.demo.Exception.WalterException;

@RestController
@RequestMapping
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/read")
    public Iterable<User> getAll(){
        return usersService.getAllUsers();
    }

    @GetMapping("/read/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId){
        User user= usersService.getUserById(userId);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            throw new WalterException("No se encontró un usuario con el ID: " + userId, null);
        }
    }
    @PostMapping("/insert")
    public ResponseEntity<User> createUser(@RequestBody UserDto user) {

        User createdUser = usersService.insertUser(user);

        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        usersService.deleteUserById(userId);
        return new ResponseEntity<>("Usuario eliminado correctamente", HttpStatus.OK);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User updatedUser) {
        User updatedUserEntity = usersService.updateUser(userId, updatedUser);
        return new ResponseEntity<>(updatedUserEntity, HttpStatus.OK);
    }

}
