package ru.itmo.loveconnect.dto;

import lombok.Value;

@Value
public class RequestPrefilledProfileDto {
    String isuNumber;
    Integer confirmationCode;
}
