package ru.itmo.loveconnect.service.impl;

import java.util.*;

import org.springframework.stereotype.Service;
import ru.itmo.loveconnect.entity.TagEntity;
import ru.itmo.loveconnect.repo.TagRepository;
import ru.itmo.loveconnect.service.TagService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;

    @Override
    public List<TagEntity> getAll() {
        return tagRepository.findAll();
    }
}
