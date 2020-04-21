package com.vyakta.covid.service.signup;

import com.vyakta.covid.model.dto.PostActivityDto;
import com.vyakta.covid.model.persistent.Address;
import com.vyakta.covid.model.persistent.Posts;
import com.vyakta.covid.model.persistent.Users;
import com.vyakta.covid.repository.AddressRepository;
import com.vyakta.covid.repository.PostsRepository;
import com.vyakta.covid.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PostActivityImpl implements PostActivity {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PostsRepository postsRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public boolean createPosts(PostActivityDto newPost) {



        Address addressObj = Address.builder()
                .addLine1(newPost.getAddLine1())
                .addLine2(newPost.getAddLine2())
                .addLine3(newPost.getAddLine3())
                .city(newPost.getCity())
                .country(newPost.getCountry())
                .landmark(newPost.getLandMark())
                .location(newPost.getLocation())
                .mailId(newPost.getMailId())
                .pincode(newPost.getPincode())
                .state(newPost.getState())
                .addressLabel("S")
                .userId(newPost.getUserId())
                .build();
        int address = newPost.getAddressId();
        if (!newPost.isRegisteredAddress()) {
            Address addressIns = addressRepository.save(addressObj);
             address = (int) addressIns.getAddressId();
        }

        Posts postObj = Posts.builder()
                .postCreateDate(newPost.getPostCreateDate())
                .postDesc(newPost.getPostDesc())
                .postEndDate(newPost.getPostEndDate())
                .postRequestDate(newPost.getPostRequestDate())
                .addressType(newPost.getAddressType())
                .quantity(newPost.getQuantity())
                .recurring(newPost.getRecurring())
                .status(newPost.getStatus())
                .userId(newPost.getUserId())
                .subType(newPost.getSubType())
                .type(newPost.getType())
                .addressId(address)
                .build();
        postsRepository.save(postObj);


        return true;
    }

    @Override
    public PostActivityDto getPost(int postId) {
        PostActivityDto post = new PostActivityDto();
        Optional<Posts> postDetail = postsRepository.findById(postId);
        if (postDetail.isPresent()) {

            post.setPostCreateDate(postDetail.get().getPostCreateDate());
            post.setPostDesc(postDetail.get().getPostDesc());
            post.setPostEndDate(postDetail.get().getPostEndDate());
            post.setPostRequestDate(postDetail.get().getPostRequestDate());
            post.setQuantity(postDetail.get().getQuantity());
            post.setRecurring(postDetail.get().getRecurring());
            post.setStatus(postDetail.get().getStatus());
            post.setSubType(postDetail.get().getSubType());
            post.setType(postDetail.get().getType());
            post.setUserId(postDetail.get().getUserId());

            Optional<Address> addressDetail = addressRepository.findById(postDetail.get().getAddressId());

            if (addressDetail.isPresent()) {
                post.setAddLine1(addressDetail.get().getAddLine1());
                post.setAddLine2(addressDetail.get().getAddLine2());
                post.setAddLine3(addressDetail.get().getAddLine3());
                post.setAddressLabel(addressDetail.get().getAddressLabel());
                post.setCity(addressDetail.get().getCity());
                post.setCountry(addressDetail.get().getCountry());
                post.setLandMark(addressDetail.get().getLandmark());
                post.setLocation(addressDetail.get().getLocation());
                post.setPincode(addressDetail.get().getPincode());
                post.setMailId(addressDetail.get().getMailId());
                post.setState(addressDetail.get().getState());
            }


        }

        return post;
    }

    @Override
    public List<PostActivityDto> showAllPostInfo() {

        List<Posts> postsList = postsRepository.findAll();

       return getPosts(postsList);
    }

    @Override
    public List<PostActivityDto> showPostInfoByUser(int userId) {
        PostActivityDto post = new PostActivityDto();
        //Optional<Posts> postDetail = postsRepository.findAll();
        List<Posts> postsList = postsRepository.findByUserId(userId);
        return getPosts(postsList);
    }

    private List<PostActivityDto> getPosts( List<Posts> postsList){
        List<PostActivityDto> postsAll = new ArrayList<>();
        postsList.forEach(posts -> {
            PostActivityDto post = new PostActivityDto();
            post.setPostCreateDate(posts.getPostCreateDate());
            post.setPostDesc(posts.getPostDesc());
            post.setPostEndDate(posts.getPostEndDate());
            post.setPostRequestDate(posts.getPostRequestDate());
            post.setQuantity(posts.getQuantity());
            post.setRecurring(posts.getRecurring());
            post.setStatus(posts.getStatus());
            post.setSubType(posts.getSubType());
            post.setType(posts.getType());
            post.setUserId(posts.getUserId());

            Optional<Address> addressDetail = addressRepository.findById(posts.getAddressId());

            if (addressDetail.isPresent()) {
                post.setAddLine1(addressDetail.get().getAddLine1());
                post.setAddLine2(addressDetail.get().getAddLine2());
                post.setAddLine3(addressDetail.get().getAddLine3());
                post.setAddressLabel(addressDetail.get().getAddressLabel());
                post.setCity(addressDetail.get().getCity());
                post.setCountry(addressDetail.get().getCountry());
                post.setLandMark(addressDetail.get().getLandmark());
                post.setLocation(addressDetail.get().getLocation());
                post.setPincode(addressDetail.get().getPincode());
                post.setMailId(addressDetail.get().getMailId());
                post.setState(addressDetail.get().getState());
            }

            postsAll.add(post);
        });


        return postsAll;

    }
}
