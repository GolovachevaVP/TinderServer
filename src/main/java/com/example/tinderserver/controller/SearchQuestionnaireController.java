package com.example.tinderserver.controller;

import com.example.tinderserver.dto.QuestionnaireDto;
import com.example.tinderserver.service.SearchQuestionnaireService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/public/questionnaire/")
public class SearchQuestionnaireController {
    private final SearchQuestionnaireService searchQuestionnaireService;

    @GetMapping
    public QuestionnaireDto getSearchQuestionnaire(Long chatId, HttpServletResponse response) throws IOException {
        return searchQuestionnaireService.getQuestionnaire(chatId, response);
    }

}
