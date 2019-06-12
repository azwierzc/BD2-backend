package com.isieiti.bdproject.dto;

import com.isieiti.bdproject.enums.MedicalEmployeeRole;
import com.isieiti.bdproject.enums.ReportType;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
public class ReportDTO {

    private Long id;

    private LocalDateTime creationTimestamp;

    private boolean closed;

    private String content;

    private Long employeeId;

    private String employeeName;

    private String employeeSurname;

    private MedicalEmployeeRole employeeType;

    private ReportType reportType;
}
