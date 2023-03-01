package com.example.JobListingAndPosting.service;

import com.example.JobListingAndPosting.model.Post;

import java.io.IOException;
import java.util.List;

public interface PostRepositoryService {

    List<Post> getAllPosts();

    Post getPost(Long id) throws IOException;
    void createPost(Post post);
    void updatePost(Long id, Post post) throws IOException;
    void deletePost(Long id);
    List<Post> getPostByExperience(int experience);
    List<Post> getPostsByHighExperience(int experience);
    List<Post> getPostsByLowExperience(int experience);
    List<Post> getPostsBySkill(String skill);

    List<Post> getPostsBySkillSets(List<String> skillSets);
    List<Post> getPostsBySkillsSortedByExperience(String skill);

    int getCountOfPostsForExperience(int experience);

}