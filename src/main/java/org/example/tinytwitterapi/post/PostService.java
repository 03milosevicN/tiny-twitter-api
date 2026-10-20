package org.example.tinytwitterapi.post;

import java.time.Instant;
import org.example.tinytwitterapi.common.ResourceNotFoundException;
import org.example.tinytwitterapi.like.Like;
import org.example.tinytwitterapi.like.LikeRepository;
import org.example.tinytwitterapi.post.dto.PostReq;
import org.example.tinytwitterapi.post.dto.PostRes;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j 
@Service 
@RequiredArgsConstructor 
public class PostService {
    
    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final LikeRepository likeRepository;
    
    
    public PostRes getPostById(Long id) {
        return postRepository
            .findById(id)
            .map(postMapper::toResponse)
            .orElseThrow(() -> new ResourceNotFoundException("Cannot find post with id of " + id));
    }
    
    public PostRes createPost(PostReq req) {
        var model = postMapper.toModel(req);
        model.setCreatedAt(Instant.now());
        var saved = postRepository.save(model);
        log.info("CREATED POST: {}", saved.getContent());
        return postMapper.toResponse(saved);
    }

    @Transactional 
    public PostRes likePost(Long id) {
        Post likedPost = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cannot like post. Post with id of " + id + " not found."));

        var likeObj = new Like();
        likeObj.setPost(likedPost);
        likeObj.setLikedAt(Instant.now());
        likeRepository.save(likeObj);

        likedPost.getLikes().add(likeObj);
        log.info("Liked post {}.", likedPost.getPostId());

        return postMapper.toResponse(likedPost);
    }

}
