package ru.itmo.loveconnect.dto;

import java.util.*;

import ru.itmo.loveconnect.entity.enums.TagCategory;

import lombok.Value;

/**
 * DTO for {@link ru.itmo.loveconnect.entity.TagEntity}
 */
@Value
public class TagDto {
    UUID id;
    String name;
    String emoji;
    TagCategory category;
}
