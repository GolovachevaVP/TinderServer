package com.example.tinderserver.dto;

import com.example.tinderserver.enums.GenderTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuestionnaireDto {
    private Long chatId;
    private GenderTypeEnum gender;
    private String name;
    private String description;
    //GenderTypeEnum preferences;
}
