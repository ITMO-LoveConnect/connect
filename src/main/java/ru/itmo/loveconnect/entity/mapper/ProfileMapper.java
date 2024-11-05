package ru.itmo.loveconnect.entity.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import ru.itmo.loveconnect.dto.ProfileDto;
import ru.itmo.loveconnect.entity.ProfileEntity;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProfileMapper {
    ProfileEntity toEntity(ProfileDto profileDto);

    ProfileDto toDto(ProfileEntity profileEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ProfileEntity partialUpdate(ProfileDto profileDto, @MappingTarget ProfileEntity profileEntity);
}