package acmlira.awesomebank.api.dto.mapper;

import acmlira.awesomebank.api.dto.TagDto;
import acmlira.awesomebank.api.model.Tag;

public class TagDtoMapper {
    public static TagDto writeDto(Tag tag) {
        return new TagDto(tag.getId(), tag.getCode());
    }
}
