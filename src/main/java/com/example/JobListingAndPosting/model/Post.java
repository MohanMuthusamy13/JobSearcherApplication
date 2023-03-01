package com.example.JobListingAndPosting.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "JobPost")

public class Post {

    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";

    @Id
    private long id;
    private String desc;
    private int exp;
    private String profile;
    private String[] techs;
}