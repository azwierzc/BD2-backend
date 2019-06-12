package com.isieiti.bdproject.dto;

import com.isieiti.bdproject.enums.ReportType;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
public class ReportPostDTO {

    private Long id;

    private LocalDateTime creationTimestamp;

    @NotBlank
    private String content;

    private boolean closed;

    private Long employeeId;

    private ReportType reportType;
}
