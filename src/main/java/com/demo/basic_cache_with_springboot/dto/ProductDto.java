package com.demo.basic_cache_with_springboot.dto;

import java.util.UUID;

public record ProductDto(UUID id, String name, String description) {
}
