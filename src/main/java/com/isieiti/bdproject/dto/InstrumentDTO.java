package com.isieiti.bdproject.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
public class InstrumentDTO {

    private Long id;

    @NotBlank
    private String type;

    @NotBlank
    private String serialNumber;

    private LocalDateTime lastCheckTimestamp;

    private LocalDateTime checkPeriod;

}
