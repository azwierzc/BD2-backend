package com.isieiti.bdproject.dto;

import com.isieiti.bdproject.enums.RoomType;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RoomDTO {

    private Long id;

    private boolean avaliable;

    private RoomType type;

    @NotNull
    private int number;
}
