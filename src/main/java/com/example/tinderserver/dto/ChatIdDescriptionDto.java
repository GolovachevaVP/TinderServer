package com.example.tinderserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChatIdDescriptionDto {
    private Long chatId;
    private String description;

}
