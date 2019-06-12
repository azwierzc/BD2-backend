package com.isieiti.bdproject.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class RoomDTO {

    private Long id;

    private boolean avaliable;

    @NotBlank
    private String type;

    @NotNull
    private int number;
}
