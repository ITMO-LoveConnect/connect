package ru.itmo.loveconnect.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itmo.loveconnect.entity.FacultyEntity;
import ru.itmo.loveconnect.repo.FacultyRepository;
import ru.itmo.loveconnect.service.FacultyService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository facultyRepository;

    @Override
    public FacultyEntity saveFacultyByShortName(final String shortName) {
        final Optional<FacultyEntity> facultyOpt = facultyRepository.findByShortName(shortName);
        if (facultyOpt.isPresent()) {
            return facultyOpt.get();
        }
        final FacultyEntity newFaculty = new FacultyEntity();
        newFaculty.setShortName(shortName);
        return facultyRepository.save(newFaculty);
    }
}
