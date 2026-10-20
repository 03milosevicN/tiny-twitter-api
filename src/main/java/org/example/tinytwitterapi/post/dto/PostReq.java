package org.example.tinytwitterapi.post.dto;

import java.time.Instant;
import java.util.List;

import lombok.Data;
import org.example.tinytwitterapi.tags.Tag;

@Data 
public class PostReq {
    private String content;
    private Instant createdAt;
    private List<Tag> tags;
}