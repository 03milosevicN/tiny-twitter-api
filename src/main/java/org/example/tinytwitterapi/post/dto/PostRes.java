package org.example.tinytwitterapi.post.dto;

import java.time.Instant;
import java.util.List;
import lombok.Data;
import org.example.tinytwitterapi.like.Like;
import org.example.tinytwitterapi.tags.Tag;

@Data 
public class PostRes {
    private Long postId;
    private String content;
    private Instant createdAt;
    private List<Like> likes;
    private List<Tag> tags;
}
