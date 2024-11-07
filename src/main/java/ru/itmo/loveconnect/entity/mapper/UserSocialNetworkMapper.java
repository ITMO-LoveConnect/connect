package ru.itmo.loveconnect.entity.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import ru.itmo.loveconnect.dto.UserSocialNetworkDto;
import ru.itmo.loveconnect.entity.UserSocialNetworkEntity;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserSocialNetworkMapper {
    UserSocialNetworkEntity toEntity(UserSocialNetworkDto userSocialNetworkDto);

    UserSocialNetworkDto toDto(UserSocialNetworkEntity userSocialNetworkEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    UserSocialNetworkEntity partialUpdate(UserSocialNetworkDto userSocialNetworkDto, @MappingTarget UserSocialNetworkEntity userSocialNetworkEntity);
}
