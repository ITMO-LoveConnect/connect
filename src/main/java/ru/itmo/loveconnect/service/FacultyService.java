package ru.itmo.loveconnect.service;

import ru.itmo.loveconnect.entity.FacultyEntity;

public interface FacultyService {
    FacultyEntity saveFacultyByShortName(String shortName);
}
