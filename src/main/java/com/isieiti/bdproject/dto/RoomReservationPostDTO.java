package com.isieiti.bdproject.dto;


import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class RoomReservationPostDTO {

    private Long id;

    @NotNull
    private LocalDateTime startTimestamp;

    @NotNull
    private LocalDateTime endTimestamp;

    private Long employeeId;

    private Long roomId;
}

