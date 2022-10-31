package com.example.tinderserver.service;

import com.example.tinderserver.dto.ChatIdDescriptionDto;
import com.example.tinderserver.dto.QuestionnaireDto;
import com.example.tinderserver.repository.QuestionnaireRepository;
import com.example.tinderserver.repository.TextToImageRepository;
import feign.Response;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

@Service
@RequiredArgsConstructor
public class SearchQuestionnaireService {

    private final TextToImageRepository textToImageRepository;
    private final QuestionnaireRepository questionnaireRepository;

    public void getQuestionnaire(Long chatId, HttpServletResponse response) throws IOException {
        QuestionnaireDto questionnaireDto = questionnaireRepository.getSearchQuestionnaire(chatId);
        ChatIdDescriptionDto chatIdDescriptionDto = new ChatIdDescriptionDto(
                questionnaireDto.getChatId(),
                questionnaireDto.getDescription()
        );

        Response downloadFileResponse = textToImageRepository.textToImage(chatIdDescriptionDto);

        setHeaderFromFeignResponse(HttpHeaders.CONTENT_TYPE, response, downloadFileResponse);
        setHeaderFromFeignResponse(HttpHeaders.CONTENT_DISPOSITION, response, downloadFileResponse);
        IOUtils.copy(downloadFileResponse.body().asInputStream(), response.getOutputStream());
    }

    private void setHeaderFromFeignResponse(
            String httpHeaderType,
            HttpServletResponse servletResponse,
            Response feignResponse
    ) {
        servletResponse.setHeader(
                httpHeaderType,
                feignResponse.headers()
                        .get(httpHeaderType)
                        .stream()
                        .findFirst()
                        .orElseThrow(() -> new IllegalStateException("Unknown " + httpHeaderType))
        );

    }
}