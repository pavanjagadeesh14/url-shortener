package com.jagadeesh.urlshortener.controller;

import com.jagadeesh.urlshortener.dto.ShortenUrlRequest;
import com.jagadeesh.urlshortener.service.UrlService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/shorten")
    public Map<String, String> shorten(@Valid @RequestBody ShortenUrlRequest request) {
        String shortCode = urlService.shortenUrl(request.getOriginalUrl());
        return Map.of(
                "shortUrl", "http://localhost:8080/" + shortCode);
    }
}
