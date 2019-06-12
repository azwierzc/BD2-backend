package com.isieiti.bdproject.dto;


import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class RoomReservationPostDTO {

    @NotNull
    private Long id;

    @NotNull
    private LocalDateTime startTimestamp;

    @NotNull
    private LocalDateTime endTimestamp;

    @NotNull
    private Long employeeId;

    @NotNull
    private Long roomId;
}

