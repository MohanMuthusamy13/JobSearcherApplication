package com.example.JobListingAndPosting.controller;


import com.example.JobListingAndPosting.model.Post;
import com.example.JobListingAndPosting.service.PostRepositoryServiceImpl;
import com.example.JobListingAndPosting.service.SequenceGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
public class JobPostController {

    @Autowired
    PostRepositoryServiceImpl postRepositoryService;

    @Autowired
    SequenceGenerator sequenceGenerator;

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getAllPosts() {
        return new ResponseEntity<>(postRepositoryService.getAllPosts(), HttpStatus.OK);
    }

    @GetMapping("/post")
    public ResponseEntity<Post> getPost(@RequestParam(value = "id") Long id) throws IOException {
        return new ResponseEntity<>(postRepositoryService.getPost(id), HttpStatus.OK);
    }

    @PostMapping("/addPost")
    public ResponseEntity<HttpStatus> createPost(@RequestBody Post post) {
        post.setId(sequenceGenerator.getSequenceNumber(Post.SEQUENCE_NAME));
        postRepositoryService.createPost(post);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/updatePost")
    public ResponseEntity<HttpStatus> updatePost(
            @RequestParam(value = "id") Long id, @RequestBody Post post
    ) throws IOException {
        postRepositoryService.updatePost(id, post);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deletePost")
    public ResponseEntity<HttpStatus> deletePost(@RequestParam(value = "id")Long id) {
        postRepositoryService.deletePost(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}