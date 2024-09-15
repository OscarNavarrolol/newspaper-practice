package com.newspaper.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record NewDto(@NotBlank @Size(min = 5, max = 100) String title,
                     @NotBlank String content,
                     @NotNull @PastOrPresent LocalDate publicationDate) {

    public NewDto(String title, String content, LocalDate publicationDate) {
        this.title = title;
        this.content = content;
        this.publicationDate = publicationDate;
    }
}
