package com.example.JobListingAndPosting.service;

import com.example.JobListingAndPosting.model.DBSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class SequenceGenerator {

    @Autowired
    private MongoOperations mongoOperations;

    public int getSequenceNumber(String sequenceName) {
        Query query = new Query(Criteria.where("id").is(sequenceName));
        Update update = new Update().inc("seq", 1);
        DBSequence counter = mongoOperations.findAndModify(
                query, update, FindAndModifyOptions.options().returnNew(true).upsert(true),
                DBSequence.class);

        return !Objects.isNull(counter)? counter.getSeq(): 1;
    }


}