package org.example.tinytwitterapi.tags;

import org.example.tinytwitterapi.tags.dto.TagReq;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TagMapper {

    @Mapping(target = "tagId", ignore = true)
    Tag toModel(TagReq req);

}
