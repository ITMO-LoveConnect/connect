package ru.itmo.loveconnect.entity.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ru.itmo.loveconnect.dto.TagDto;
import ru.itmo.loveconnect.entity.TagEntity;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TagMapper {
    TagDto toDto(final TagEntity tagEntity);
}
