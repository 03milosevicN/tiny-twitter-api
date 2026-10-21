package org.example.tinytwitterapi.views;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/views")
public class ViewCountController {

    private final ViewCountService service;


    @GetMapping("/post/{id}")
    public ResponseEntity<Long> getPostViewCount(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getPostViewCount(id));
    }

}
