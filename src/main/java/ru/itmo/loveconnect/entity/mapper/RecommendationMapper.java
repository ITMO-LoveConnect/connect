package ru.itmo.loveconnect.entity.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import ru.itmo.loveconnect.dto.GetRecommendationDto;
import ru.itmo.loveconnect.entity.UserEntity;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {ProfileMapper.class})
public interface RecommendationMapper {
    UserEntity toEntity(GetRecommendationDto getRecommendationDto);

    GetRecommendationDto toDto(UserEntity userEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    UserEntity partialUpdate(GetRecommendationDto getRecommendationDto, @MappingTarget UserEntity userEntity);
}