package com.mtzperez.springidea.model.dto;


import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
public class BikeDto {
    @NotNull
    @NotBlank
    @Getter
    @Pattern(regexp = "^[a-zA-Z ]*$")
    public String name;

    public BikeDto(String name) {
        this.name = name;
    }
}