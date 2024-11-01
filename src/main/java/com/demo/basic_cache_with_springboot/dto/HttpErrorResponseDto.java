package com.demo.basic_cache_with_springboot.dto;

import java.time.Instant;

public record HttpErrorResponseDto(Instant timestamp,
                                   Integer httpStatus,
                                   String error,
                                   String errorMessage,
                                   String path) {
}
