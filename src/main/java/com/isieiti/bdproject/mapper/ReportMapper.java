package com.isieiti.bdproject.mapper;

import com.isieiti.bdproject.dto.ReportDTO;
import com.isieiti.bdproject.dto.ReportPostDTO;
import com.isieiti.bdproject.entity.Report;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ReportMapper {

    @Mappings({
            @Mapping(target = "employeeName", source = "report.employee.name"),
            @Mapping(target = "employeeSurname", source = "report.employee.surname"),
            @Mapping(target = "employeeType", source = "report.employee.type"),
            @Mapping(target = "reportType", source = "report.type"),
            @Mapping(target = "content", source = "report.content")
    })
    public abstract ReportDTO toReportDTO(Report report);

    @Mappings({
            @Mapping(target = "employeeId", source = "employee.id"),
            @Mapping(target = "reportType", source = "type"),
            @Mapping(target = "content", source = "content")
    })
    public abstract ReportPostDTO toReportPostDTO(Report report);

    public abstract List<ReportDTO> toReportDTOs(List<Report> reports);

    @Mappings({
            @Mapping(target = "employee.id", source = "employeeId"),
            @Mapping(target = "type", source = "reportType"),
            @Mapping(target = "content", source = "content")
    })
    public abstract Report toReport(ReportPostDTO reportPostDTO);
}
