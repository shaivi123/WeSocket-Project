package com.springrest.webSocket.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Message")
@Setter
@ToString
@Getter
@NoArgsConstructor
public class Message {
    private String name;
    private MessageType type;
    private String content;

    public Message(String name, MessageType type, String content) {
        this.name = name;
        this.type = type;
        this.content = content;
    }
}
