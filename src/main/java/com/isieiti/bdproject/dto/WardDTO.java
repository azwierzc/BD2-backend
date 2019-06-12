package com.isieiti.bdproject.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class WardDTO {

    private Long id;

    @NotBlank
    private String name;
}
