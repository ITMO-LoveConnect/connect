package ru.itmo.loveconnect.dto;

import lombok.Value;
import ru.itmo.loveconnect.entity.enums.Gender;

@Value
public class IsuReportDto {
    String fullName;
    Gender gender;
    String facultyName;
    String group;
    String course;
}
