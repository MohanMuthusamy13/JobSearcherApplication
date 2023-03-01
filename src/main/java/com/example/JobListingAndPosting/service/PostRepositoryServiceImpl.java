package com.example.JobListingAndPosting.service;

import com.example.JobListingAndPosting.model.Post;
import com.example.JobListingAndPosting.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class PostRepositoryServiceImpl implements PostRepositoryService {

    @Autowired
    PostRepository postRepository;

    // CRUD OPERATIONS

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPost(Long id) throws IOException {
        Post tempPost;
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()) {
            tempPost = post.get();
        }
        else {
            throw new IOException("Please enter the valid id for retrieving the post :)");
        }
        return tempPost;
    }

    public void createPost(Post post) {
        postRepository.save(post);
    }

    @Override
    public void updatePost(Long id, Post updatedPost) throws IOException {
        Post jobPost;
        Optional<Post>  post= postRepository.findById(id);

        if (post.isPresent()) {
            jobPost = post.get();
        }
        else {
            throw new IOException("The post doesnt exist in the database..." +
                    "Please provide the post which is presently available");
        }
        jobPost.setDesc(updatedPost.getDesc());
        jobPost.setExp(updatedPost.getExp());
        jobPost.setProfile(updatedPost.getProfile());
        jobPost.setTechs(updatedPost.getTechs());
        postRepository.save(jobPost);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public List<Post> getPostByExperience(int experience) {
        return postRepository.getPostByExperience(experience);
    }

    @Override
    public List<Post> getPostsByHighExperience(int experience) {
        return postRepository.getPostsByHighExperience(experience);
    }

    @Override
    public List<Post> getPostsByLowExperience(int experience) {
        return postRepository.getPostsByLowExperience(experience);
    }

    @Override
    public List<Post> getPostsBySkill(String skill) {
        return postRepository.getPostsBySkill(skill);
    }

    @Override
    public List<Post> getPostsBySkillSets(List<String> skillSets) {
        return postRepository.getPostsBySkillSets(skillSets);
    }

    @Override
    public List<Post> getPostsBySkillsSortedByExperience(String skill) {
        return postRepository.getPostsBySkillSortedByExperience(skill);
    }

    @Override
    public int getCountOfPostsForExperience(int experience) {
        return postRepository.getCountOfPostsForExperience(experience);
    }
}