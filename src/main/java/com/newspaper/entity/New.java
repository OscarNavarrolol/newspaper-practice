package com.newspaper.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
@Table(name = "news")
public class New {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Size(min = 5, max = 100)
    //@NotNull(message = "not null title")
    private String title;

    //@Min(value = 5, message = "more long for message")
    //@NotBlank(message = "not null content")
    private String content;

    //@PastOrPresent
    //@NotNull(message = "not blank publication date")
    @Column(name = "publication_date")
    private LocalDate publicationDate;


    //@JsonIgnore       // LA FORMULA, colocar en caso de fallo random con foranea (pregunta primero)
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    /*public @NotNull(message = "not null category") Long setCategory() {
        return categoryId;
    }

    public void setCategoryId(@NotNull(message = "not null category") Long categoryId) {
        this.categoryId = categoryId;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
