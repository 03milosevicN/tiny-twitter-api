package org.example.tinytwitterapi.post;

import org.example.tinytwitterapi.post.dto.PostReq;
import org.example.tinytwitterapi.post.dto.PostRes;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostMapper {
    
    @Mapping(target = "id", ignore = true)
    Post toModel(PostReq req);
    PostRes toResponse(Post model);

}
