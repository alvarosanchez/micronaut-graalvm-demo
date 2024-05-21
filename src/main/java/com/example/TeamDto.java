package com.example;

import io.micronaut.serde.annotation.Serdeable;
import io.micronaut.sourcegen.annotations.Builder;

@Serdeable
@Builder
public record TeamDto(Long id, String description) {
}
