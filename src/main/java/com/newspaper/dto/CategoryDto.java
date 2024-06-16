package com.newspaper.dto;

import jakarta.validation.constraints.NotNull;

public record CategoryDto(Long id,
                          @NotNull(message = "not blank") String nameCategory) {
}
