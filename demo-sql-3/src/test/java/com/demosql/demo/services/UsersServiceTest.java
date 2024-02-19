package com.demosql.demo.services;

import com.demosql.demo.Exception.WalterException;
import com.demosql.demo.dtos.UserDto;
import com.demosql.demo.models.User;
import com.demosql.demo.repositories.UsersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.Null;
import org.mockito.stubbing.OngoingStubbing;

import java.lang.reflect.Executable;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UsersServiceTest {
    private static final String TEST_STRING = "Algo";

    @Mock
    private UsersRepository repository;
    @InjectMocks
    private UsersService service;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReturnAllUsers(){
        //arrange
        Iterable<User> list = List.of(
                User.builder()
                        .id(1L)
                        .nombre(TEST_STRING)
                        .password(TEST_STRING)
                        .build()
        );
        when(repository.findAll()).thenReturn(list);
        //act
        Iterable<User> response = service.getAllUsers();
        User user = response.iterator().next();
        assertEquals(1L,user.getId());
    }

    @Test
    public void shouldReturnUserById(){
        //arrange

        User user = User
                .builder()
                .id(1L)
                .nombre(TEST_STRING)
                .password(TEST_STRING)
                .build();
when(repository.findById(anyLong())).thenReturn(Optional.ofNullable(user));
        //act
        User response = service.getUserById(1l);
        //assert
        assertEquals(1L,response.getId());

    }

    @Test
    public void shouldInsertUser(){
        //arrange
        UserDto userDto = new UserDto(TEST_STRING, TEST_STRING);
        User user = User
                .builder()
                .id(1L)
                .nombre(TEST_STRING)
                .password(TEST_STRING)
                .build();
        when(repository.save(any(User.class))).thenReturn(user);

        //act
        User response = service.insertUser(userDto);
        //
        assertEquals(1L, response.getId());
    }

    @Test
    public void shouldDeleteUser() {

        //arrange


        //act
        service.deleteUserById(1L);
        //assert
        verify(repository).deleteById(1L);
    }

    @Test
    public void shouldReturnUpdateUser(){
        //arrange
        User user = User
                .builder()
                .id(1L)
                .nombre(TEST_STRING)
                .password(TEST_STRING)
                .build();
        when(repository.findById(anyLong())).thenReturn(Optional.ofNullable(user));
        when(repository.save(any(User.class))).thenReturn(User.builder()
                .id(1L)
                .nombre(TEST_STRING)
                .password(TEST_STRING)
                .build());


        //act
        User response = service.updateUser(1L,user);
        //assert

        assertEquals(1l,response.getId());

    }

    @Test
    public void shouldReturnNullUpdateUser(){
        //arrange
        User user = User
                .builder()
                .id(1L)
                .nombre(TEST_STRING)
                .password(TEST_STRING)
                .build();
        when(repository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(WalterException.class,()->service.updateUser(1L,user));

    }
}