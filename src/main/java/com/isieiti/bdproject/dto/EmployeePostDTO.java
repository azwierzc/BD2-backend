package com.isieiti.bdproject.dto;

import com.isieiti.bdproject.enums.MedicalEmployeeRole;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class EmployeePostDTO {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    private String prefix;

    @NotNull
    private MedicalEmployeeRole type;

    @NotNull
    private Long wardId;
}
