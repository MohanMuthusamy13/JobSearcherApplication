package com.example.JobListingAndPosting.repository;

import com.example.JobListingAndPosting.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, Long> {

    @Query(value = "{techs: ?0}", sort = "{exp: -1}")
    List<Post> getPostsBySkillSortedByExperience(String skill);

    @Query(value = "{exp: ?0}")
    List<Post> getPostByExperience(int experience);

    @Query(value = "{exp: {$gte: ?0}}")
    List<Post> getPostsByHighExperience(int experience);

    @Query(value = "{exp: {$lte: ?0}}")
    List<Post> getPostsByLowExperience(int experience);

    @Query(value = "{techs: ?0}")
    List<Post> getPostsBySkill(String skill);

    @Query(value = "{techs: {$all: ?0}}")
    List<Post> getPostsBySkillSets(List<String> skillSets);

    @Query(value = "{exp: ?0}", count = true)
    int getCountOfPostsForExperience(int experience);

}