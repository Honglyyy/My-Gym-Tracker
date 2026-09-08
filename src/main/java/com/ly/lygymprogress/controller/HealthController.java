package com.ly.lygymprogress.controller;

import com.ly.lygymprogress.dto.HealthResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    private static final HealthResponseDto HEALTH_UP = HealthResponseDto.builder()
            .status("UP")
            .build();

    @GetMapping({"/healths", "/health", "/api/v1/healths", "/api/v1/health"})
    public ResponseEntity<HealthResponseDto> checkHealth() {
        return ResponseEntity.ok(HEALTH_UP);
    }
}
