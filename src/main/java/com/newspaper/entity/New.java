package com.newspaper.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
@Table(name = "news")
public class New {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 5, max = 100)
    @NotNull(message = "not null title")
    private String title;

    @Min(value = 5, message = "more long for message")
    @NotBlank(message = "not null content")
    private String content;

    @PastOrPresent
    @NotNull(message = "not blank publication date")
    @Column(name = "publication_date")
    private LocalDate publicationDate;

    @NotNull(message = "not null userId")
    @Column(name = "user_id")
    private Long userId;

    @NotNull(message = "not null category")
    @Column(name = "category_id")
    private Long categoryId;

    public @NotNull(message = "not null category") Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(@NotNull(message = "not null category") Long categoryId) {
        this.categoryId = categoryId;
    }

    public @Min(value = 5, message = "more long for message") @NotBlank(message = "not null content") String getContent() {
        return content;
    }

    public void setContent(@Min(value = 5, message = "more long for message") @NotBlank(message = "not null content") String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @PastOrPresent @NotNull(message = "not blank publication date") LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(@PastOrPresent @NotNull(message = "not blank publication date") LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public @Size(min = 5, max = 100) @NotNull(message = "not null title") String getTitle() {
        return title;
    }

    public void setTitle(@Size(min = 5, max = 100) @NotNull(message = "not null title") String title) {
        this.title = title;
    }

    public @NotNull(message = "not null userId") Long getUserId() {
        return userId;
    }

    public void setUserId(@NotNull(message = "not null userId") Long userId) {
        this.userId = userId;
    }
}
