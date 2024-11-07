package ru.itmo.loveconnect.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(onConstructor_ = {@JsonCreator})
public class SendConfirmationDto {
    String isuNumber;
}
