package com.newspaper.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserDto(@NotBlank @Size(min = 3, max = 50) String userName,
                      @NotBlank @Size(min = 6) String password,
                      @NotBlank @Email String email) {

}
