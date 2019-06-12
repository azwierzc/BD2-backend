package com.isieiti.bdproject.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class WardDTO {

    @NotNull
    private Long id;

    @NotBlank
    private String name;
}
