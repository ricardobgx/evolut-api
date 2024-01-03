package com.evolut.api.domain.user.dtos;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record CreateUserInput(
        @NotBlank
        String name,
        @NotBlank
        String email,
        @NotBlank
        String password
) {
}
