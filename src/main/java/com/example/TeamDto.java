package com.example;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record TeamDto(Long id, String description) {
}
