package ru.itmo.loveconnect.controller;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itmo.loveconnect.dto.TagDto;
import ru.itmo.loveconnect.entity.mapper.TagMapper;
import ru.itmo.loveconnect.service.TagService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tag")
public class TagController {
    private final TagMapper mapper;
    private final TagService tagService;

    @GetMapping
    public List<TagDto> getAllTags() {
        return tagService.getAll().stream().map(mapper::toDto).toList();
    }
}
