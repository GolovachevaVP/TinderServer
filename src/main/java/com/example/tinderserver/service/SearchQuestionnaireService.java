package com.example.tinderserver.service;

import com.example.tinderserver.dto.QuestionnaireDto;
import com.example.tinderserver.repository.QuestionnaireRepository;
import com.example.tinderserver.repository.TextToImageRepository;
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

    public QuestionnaireDto getQuestionnaire(Long chatId, HttpServletResponse response) throws IOException {
        response.setContentType("image/png");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=questionnaire.png");
        response.setCharacterEncoding(StandardCharsets.UTF_8.displayName());

        QuestionnaireDto questionnaireDto = questionnaireRepository.getSearchQuestionnaire(chatId);
        InputStream inputStream = textToImageRepository.textToImage(
                        chatId,
                        questionnaireDto.getDescription()
                )
                .body()
                .asInputStream();

        BufferedOutputStream outStream = new BufferedOutputStream (response.getOutputStream());

        byte[] buffer = new byte[8 * 1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
        outStream.flush();
        return questionnaireDto;
    }
}