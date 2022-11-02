package com.springrest.webSocket.repository;

import com.springrest.webSocket.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,Integer> {
}
