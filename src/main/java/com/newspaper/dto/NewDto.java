package com.newspaper.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record NewDto(@NotNull Long id,
                     @NotBlank @Size(min = 5, max = 100) String title,
                     @NotBlank String content,
                     @NotNull @PastOrPresent LocalDate publicationDate,
                     @NotNull Long userId,
                     @NotNull Long categoryId) {
}
