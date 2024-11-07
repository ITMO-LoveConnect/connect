package ru.itmo.loveconnect.entity.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import ru.itmo.loveconnect.dto.FacultyDto;
import ru.itmo.loveconnect.entity.FacultyEntity;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface FacultyMapper {
    FacultyEntity toEntity(FacultyDto profileDto);

    FacultyDto toDto(FacultyEntity profileEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FacultyEntity partialUpdate(FacultyDto facultyDto, @MappingTarget FacultyEntity facultyEntity);
}