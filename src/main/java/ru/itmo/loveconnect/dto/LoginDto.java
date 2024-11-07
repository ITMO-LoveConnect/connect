package ru.itmo.loveconnect.dto;

import lombok.Value;

@Value
public class LoginDto {
    String isuNumber;
    Integer confirmationCode;
}
