package com.isieiti.bdproject.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class InstrumentDTO {

    @NotNull
    private Long id;

    @NotBlank
    private String type;

    @NotBlank
    private String serialNumber;

    private LocalDateTime lastCheckTimestamp;

    private LocalDateTime checkPeriod;

}
