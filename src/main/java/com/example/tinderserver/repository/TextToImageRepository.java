package com.example.tinderserver.repository;

import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "text-to-image-service",
        url = "${endpoints.text-to-image}",
        decode404 = true)
public interface TextToImageRepository {
  @GetMapping("/internal/image/from/text")
  Response textToImage(
          @RequestParam Long chatId,
          @RequestParam String description
  );
}
