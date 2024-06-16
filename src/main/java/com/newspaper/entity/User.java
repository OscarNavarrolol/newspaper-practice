package com.newspaper.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "not null userName")
    @Size(min = 3, max = 50)
    @Column(name = "user_name")
    private String userName;

    @NotBlank(message = "not null password")
    @Size(min = 6)
    private String password;

    @NotBlank(message = "not null email")
    @Email(message = "not bad email")
    private String email;

    public @NotBlank(message = "not null email") @Email(message = "not bad email") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "not null email") @Email(message = "not bad email") String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "not null password") @Size(min = 6) String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "not null password") @Size(min = 6) String password) {
        this.password = password;
    }

    public @NotBlank(message = "not null userName") @Size(min = 3, max = 50) String getUserName() {
        return userName;
    }

    public void setUserName(@NotBlank(message = "not null userName") @Size(min = 3, max = 50) String userName) {
        this.userName = userName;
    }
}
