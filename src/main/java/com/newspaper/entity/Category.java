package com.newspaper.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "not blank")
    @Column(name = "name_category")
    private String nameCategory;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL, orphanRemoval = true)
    Set<New> news;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(message = "not blank") String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(@NotNull(message = "not blank") String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
