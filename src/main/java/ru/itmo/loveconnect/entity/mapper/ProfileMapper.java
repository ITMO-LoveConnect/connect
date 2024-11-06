package ru.itmo.loveconnect.entity.mapper;

import org.mapstruct.*;
import ru.itmo.loveconnect.dto.ProfileDto;
import ru.itmo.loveconnect.entity.ProfileEntity;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProfileMapper {
    ProfileEntity toEntity(ProfileDto profileDto);

    ProfileDto toDto(ProfileEntity profileEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ProfileEntity partialUpdate(ProfileDto profileDto, @MappingTarget ProfileEntity profileEntity);
}