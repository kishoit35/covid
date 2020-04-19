package com.vyakta.covid.controller;

import com.vyakta.covid.model.dto.PostActivityDto;
import com.vyakta.covid.model.dto.UserRegistrationDto;
import com.vyakta.covid.service.signup.PostActivity;
import com.vyakta.covid.service.signup.UserRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PostController {
    @Autowired
    private PostActivity postActivity;

    @PostMapping(path="/createPost",consumes = MediaType.APPLICATION_JSON_VALUE)
    public PostActivityDto signUpUser(@RequestBody PostActivityDto newPost) {
        postActivity.createPosts(newPost);
        return newPost;
    }

    @GetMapping(path="/getPostInfo/{postId}")
    public ResponseEntity<PostActivityDto> getPostInformation(@PathVariable(value="postId") int pid) {
        PostActivityDto postInfo = postActivity.getPost(pid);
        return ResponseEntity.ok().body(postInfo);
    }

    @GetMapping(path="/getAllPostInfo")
    public List<PostActivityDto> getAllPostInformation() {
        return postActivity.showAllPostInfo();
    }

    @GetMapping(path="/getAllPostByUser/{userId}")
    public List<PostActivityDto> getAllPostInformation(@PathVariable(value="userId") int userId) {
        return postActivity.showPostInfoByUser(userId);
    }

}
