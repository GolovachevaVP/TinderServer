package com.example.tinderserver.repository;

import com.example.tinderserver.dto.ChatIdDescriptionDto;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "text-to-image-service",
        url = "${endpoints.text-to-image-service}",
        decode404 = true)
public interface TextToImageRepository {
    @PostMapping("/internal/image/from/text/")
    Response textToImage(
            @RequestBody ChatIdDescriptionDto chatIdDescriptionDto
    );

    @PostMapping("/internal/image/test/")
    String test(
            @RequestBody ChatIdDescriptionDto chatIdDescriptionDto
    );
}
