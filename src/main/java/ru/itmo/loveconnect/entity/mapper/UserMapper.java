package ru.itmo.loveconnect.entity.mapper;

import org.mapstruct.*;
import ru.itmo.loveconnect.dto.UserDto;
import ru.itmo.loveconnect.entity.UserEntity;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    UserEntity toEntity(final UserDto userDto);

    UserDto toDto(final UserEntity userEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    UserEntity partialUpdate(final UserDto userDto, @MappingTarget final UserEntity userEntity);
}