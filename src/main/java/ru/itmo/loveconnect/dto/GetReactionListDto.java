package ru.itmo.loveconnect.dto;

import lombok.Value;

import java.util.List;

@Value
public class GetReactionListDto {
    List<GetReactionDto> reactions;
}
