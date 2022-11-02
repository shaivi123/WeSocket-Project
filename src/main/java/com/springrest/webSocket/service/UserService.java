package com.springrest.webSocket.service;

import com.springrest.webSocket.model.DbSequence;
import com.springrest.webSocket.model.User;
import com.springrest.webSocket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import java.util.Objects;
import static com.springrest.webSocket.model.User.SEQUENCE_NAME;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MongoOperations mongoOperations;

    public User createUser(String userName, String password) {
        User user=new User();
        user.setId(getSequenceNumber(SEQUENCE_NAME));
        user.setUserName(userName);
        user.setPassword(password);
        return userRepository.save(user);
    }
    //This method is used to getting the data by id
    //becoz here we save id in normal(increment)format
    public int getSequenceNumber(String sequenceName) {
        //get sequence no
        Query query = new Query(Criteria.where("id").is(sequenceName));
        //update the sequence no
        Update update = new Update().inc("seq", 1);
        //modify in document
        DbSequence counter = mongoOperations
                .findAndModify(query,
                        update, options().returnNew(true).upsert(true),
                        DbSequence.class);

        return !Objects.isNull(counter) ? counter.getSeq() : 1;
    }

}
