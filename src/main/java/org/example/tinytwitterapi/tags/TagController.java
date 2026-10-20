package org.example.tinytwitterapi.tags;

import lombok.RequiredArgsConstructor;
import org.example.tinytwitterapi.tags.dto.TagReq;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tags")
public class TagController {

    private final TagService service;

    @GetMapping("/{id}")
    public ResponseEntity<Tag> getTagById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getPostById(id));
    }

    @PostMapping
    public ResponseEntity<Tag> createTag(@RequestBody TagReq req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createTag(req));
    }

}
