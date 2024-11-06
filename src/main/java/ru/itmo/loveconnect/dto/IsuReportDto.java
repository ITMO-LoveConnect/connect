package ru.itmo.loveconnect.dto;

import lombok.Value;

@Value
public class IsuReportDto {
    String fullName;
    Gender gender;
    String facultyName;
    String group;
    String course;

    public enum Gender {
        MALE, FEMALE
    }
}
