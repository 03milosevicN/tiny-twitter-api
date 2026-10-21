package org.example.tinytwitterapi.views;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.tinytwitterapi.post.Post;
import org.example.tinytwitterapi.post.dto.PostRes;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Vector;

@Slf4j
@Service
@RequiredArgsConstructor
public class ViewCountService {

    private final ViewCountRepository repository;


    public Long getPostViewCount(Long id) {
        return repository.getPostViewCount(id);
    }

    public void persistView(Post postObj) {
        var viewCountObj = new ViewCount();
        viewCountObj.setViewedAt(Instant.now());
        viewCountObj.setPost(postObj);
        repository.save(viewCountObj);
        log.info("Post [ {} ] viewed @ {}", postObj.getContent(), Instant.now());
    }

}
