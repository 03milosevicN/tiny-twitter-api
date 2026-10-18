package org.example.tinytwitterapi.post.dto;

import java.time.Instant;
import java.util.List;

import lombok.Data;
import org.example.tinytwitterapi.like.Like;

@Data 
public class PostRes {
    private Long id;
    private String content;
    private Instant createdAt;
    private List<Like> likes;
}
