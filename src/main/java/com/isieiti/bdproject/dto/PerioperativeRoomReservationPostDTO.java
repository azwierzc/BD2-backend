package com.isieiti.bdproject.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PerioperativeRoomReservationPostDTO {

    private Long id;

    private LocalDateTime startTimestamp;

    private LocalDateTime endTimestamp;

    private Long employeeId;

    private Long roomId;
}
