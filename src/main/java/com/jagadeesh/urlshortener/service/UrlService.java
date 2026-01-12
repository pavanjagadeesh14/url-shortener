package com.jagadeesh.urlshortener.service;

import com.jagadeesh.urlshortener.model.UrlMapping;
import com.jagadeesh.urlshortener.repository.UrlMappingRepository;
import com.jagadeesh.urlshortener.util.Base62Encoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UrlService {

    private final UrlMappingRepository repository;

    public UrlService(UrlMappingRepository repository) {
        this.repository = repository;
    }

    public String getOriginalUrl(String shortCode) {

        UrlMapping mapping = repository.findByShortCode(shortCode)
                .orElseThrow(() -> new RuntimeException("Short URL not found"));

        mapping.setClick_count(mapping.getClick_count() + 1);
        repository.save(mapping);

        return mapping.getOriginalUrl();
    }

    public String shortenUrl(String originalUrl) {

        // 1️⃣ If already exists, return existing short code
        return repository.findByOriginalUrl(originalUrl)
                .map(UrlMapping::getShortCode)
                .orElseGet(() -> {

                    // 2️⃣ Generate short code FIRST (NO NULL EVER)
                    long uniqueNumber = System.currentTimeMillis();
                    String shortCode = Base62Encoder.encode(uniqueNumber);

                    UrlMapping mapping = UrlMapping.builder()
                            .originalUrl(originalUrl)
                            .shortCode(shortCode) // ✅ NEVER NULL
                            .click_count(0L)
                            .createdAt(LocalDateTime.now())
                            .build();

                    repository.save(mapping);
                    return shortCode;
                });
    }
}
