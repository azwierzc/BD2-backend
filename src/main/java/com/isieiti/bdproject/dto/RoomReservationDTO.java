package com.isieiti.bdproject.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RoomReservationDTO {

    private Long id;

    private LocalDateTime startTimestamp;

    private LocalDateTime endTimestamp;

    private Long employeeId;

    private String employeePrefix;

    private String employeeName;

    private String employeeSurname;

    private String employeeType;

    private Long roomId;

    private int roomNumber;

    private String roomType;

}
