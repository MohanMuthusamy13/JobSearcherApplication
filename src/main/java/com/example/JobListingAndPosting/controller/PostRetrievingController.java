package com.example.JobListingAndPosting.controller;

import com.example.JobListingAndPosting.model.Post;
import com.example.JobListingAndPosting.service.PostRepositoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostRetrievingController {

    @Autowired
    PostRepositoryServiceImpl postRepositoryService;


    @GetMapping("/getPostsBySkillSortedByExperience")
    public List<Post> getPostsBySkillSortedByExperience(@RequestParam(value = "skill") String skill) {
        return postRepositoryService.getPostsBySkillsSortedByExperience(skill);
    }

    @GetMapping("/postsByExperience")
    public ResponseEntity<List<Post>> getPostByExperience(@RequestParam(value = "experience") int experience) {
        return new ResponseEntity<>(postRepositoryService.getPostByExperience(experience), HttpStatus.OK);
    }

    @GetMapping("/postsByHighExperience")
    public ResponseEntity<List<Post>> getPostByHigherExperience(
            @RequestParam(value = "experience") int experience
    ) {
        return new ResponseEntity<>(postRepositoryService.getPostsByHighExperience(experience), HttpStatus.OK);
    }

    @GetMapping("/postsByLowExperience")
    public ResponseEntity<List<Post>> getPostByLowExperience(
            @RequestParam(value = "experience") int experience
    ) {
        return new ResponseEntity<>(postRepositoryService.getPostsByLowExperience(experience), HttpStatus.OK);
    }

    @GetMapping("/postsBySkill")
    public ResponseEntity<List<Post>> getPostsBySkill(@RequestParam(value = "skill") String skill) {
        return new ResponseEntity<>(postRepositoryService.getPostsBySkill(skill), HttpStatus.OK);
    }

    @GetMapping("postsBySkillSets")
    public ResponseEntity<List<Post>> getPostsBySkillSets(
            @RequestParam(value = "skillSets") List<String> skillsets
    ) {
        return new ResponseEntity<>(postRepositoryService.getPostsBySkillSets(skillsets), HttpStatus.OK);
    }

    @GetMapping("/countPostsForExperience")
    public ResponseEntity<Integer> getCountOfPostsForExperience(@RequestParam(value = "experience") int experience) {
        return new ResponseEntity<>(postRepositoryService.getCountOfPostsForExperience(experience), HttpStatus.OK);
    }
}