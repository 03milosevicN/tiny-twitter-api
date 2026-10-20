package org.example.tinytwitterapi.tags;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.tinytwitterapi.common.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository repository;
    private final TagMapper mapper;


    public Tag getPostById(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cannot find tag with id of " + id + "."));
    }

    public Tag createTag(TagReq req) {
        var sb = new StringBuilder(req.getHashtag());
        var hashtag = sb.insert(0, "#");
        req.setHashtag(String.valueOf(hashtag));
        var model = mapper.toModel(req);
        log.info("CREATED TAG: {}", model.getHashtag());
        return model;
    }

}
