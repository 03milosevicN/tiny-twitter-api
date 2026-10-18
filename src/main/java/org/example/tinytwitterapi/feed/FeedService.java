package org.example.tinytwitterapi.feed;

import org.example.tinytwitterapi.post.PostMapper;
import org.example.tinytwitterapi.post.PostRepository;
import org.example.tinytwitterapi.post.dto.PostRes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
public class FeedService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;


    public Page<PostRes> getFeed(Pageable pageable) {
        return postRepository.findAll(pageable).map(postMapper::toResponse);
    }

}
