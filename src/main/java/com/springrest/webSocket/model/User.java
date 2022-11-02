package com.springrest.webSocket.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collation = "User")
public class User {

    public  static final String SEQUENCE_NAME="user_sequence";

    @Id
    private int id;
    private String userName;
    private String password;
}
