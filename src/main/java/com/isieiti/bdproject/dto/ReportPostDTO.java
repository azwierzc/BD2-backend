package com.isieiti.bdproject.dto;

import com.isieiti.bdproject.enums.ReportType;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class ReportPostDTO {

    private Long id;

    @NotNull
    private LocalDateTime creationTimestamp;

    @NotBlank
    private String content;

    @NotNull
    private boolean closed;

    @NotNull
    private Long employeeId;

    private ReportType reportType;
}
