package org.example.tinytwitterapi.post;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.example.tinytwitterapi.post.dto.PostReq;
import org.example.tinytwitterapi.post.dto.PostRes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController 
@RequiredArgsConstructor 
@RequestMapping("/posts")
public class PostController {
    
    private final PostService service;


    @GetMapping("/{id}")
    public ResponseEntity<PostRes> getPostById(@PathVariable Long id) {
        var res = service.getPostById(id);
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
