package org.example.tinytwitterapi.post;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.example.tinytwitterapi.post.dto.PostReq;
import org.example.tinytwitterapi.post.dto.PostRes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Slf4j
@RestController 
@RequiredArgsConstructor 
@RequestMapping("/posts")
public class PostController {
    
    private final PostService service;


    @GetMapping("/{id}")
    public ResponseEntity<PostRes> getPostById(
            @PathVariable Long id,
            @RequestHeader(value = "User-Agent", required = false) String userAgent,
            @RequestHeader(value = "X-Request-Id", required = false) String requestId,
            HttpServletRequest request
    ) {
        var res = service.getPostById(id);
        log.info("User-Agent header for post id: {} -> {}", id, userAgent);
        log.info("X-Request-Id header for post id: {} -> {}", id, requestId);
        log.info("Remote IP: for post id: {} -> {}", id, request.getRemoteUser());
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
    
    @PostMapping
    public ResponseEntity<PostRes> createPost(@RequestBody PostReq req) {
        var res = service.createPost(req);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
    
    @PostMapping("/{id}/like")
    public ResponseEntity<PostRes> likePost(@PathVariable Long id) {        
        var res = service.likePost(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }
    
}
