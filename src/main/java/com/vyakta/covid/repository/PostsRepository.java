package com.vyakta.covid.repository;

import com.vyakta.covid.model.dto.PostActivityDto;
import com.vyakta.covid.model.persistent.Posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Integer> {
    public List<Posts> findByUserId(int userId);
}
