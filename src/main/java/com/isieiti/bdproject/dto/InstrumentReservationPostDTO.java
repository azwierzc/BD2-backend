package com.isieiti.bdproject.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class InstrumentReservationPostDTO {

    @NotNull
    private Long id;

    @NotNull
    private LocalDateTime startTimestamp;

    @NotNull
    private LocalDateTime endTimestamp;

    @NotNull
    private Long employeeId;

    @NotNull
    private Long instrumentId;
}
