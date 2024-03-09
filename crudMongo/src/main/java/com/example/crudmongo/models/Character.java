package com.example.crudmongo.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;


@Data
@Document(value = "Characters")
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Character {
    @Id
    private String id;

    private String name;

    private String lastName;

    private String age;


}
