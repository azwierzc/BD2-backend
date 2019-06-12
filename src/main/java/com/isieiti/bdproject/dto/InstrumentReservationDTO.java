package com.isieiti.bdproject.dto;

import com.isieiti.bdproject.enums.MedicalEmployeeRole;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InstrumentReservationDTO {

    private Long id;

    private LocalDateTime startTimestamp;

    private LocalDateTime endTimestamp;

    private Long employeeId;

    private String employeeName;

    private String employeeSurname;

    private String employeePrefix;

    private MedicalEmployeeRole employeeType;

    private Long instrumentId;

    private String serialNumber;

    private String instrumentType;
}
