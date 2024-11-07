package ru.itmo.loveconnect.dto;

import lombok.Value;
import ru.itmo.loveconnect.entity.enums.*;

import java.util.List;
import java.util.UUID;

@Value
public class RegisterDto {
    String isuNumber;
    Integer confirmationCode;
    ProfileDto profile;
}