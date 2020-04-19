package com.vyakta.covid.service.signup;

import com.vyakta.covid.model.dto.PostActivityDto;

import java.util.List;

public interface PostActivity {
    public boolean createPosts(PostActivityDto newPost);
    public PostActivityDto getPost(int postId);
    public List<PostActivityDto> showAllPostInfo();
    public List<PostActivityDto> showPostInfoByUser(int userId);
}
