package org.example.tinytwitterapi.post.dto;

import java.time.Instant;
import lombok.Data;

@Data 
public class PostReq {
    private String content;
    private Instant createdAt;
}