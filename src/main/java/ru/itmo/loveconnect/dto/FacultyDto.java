package ru.itmo.loveconnect.dto;

import lombok.Value;

import java.util.UUID;

/**
 * DTO for {@link ru.itmo.loveconnect.entity.FacultyEntity}
 */
@Value
public class FacultyDto {
    UUID id;
    String shortName;
}