package com.isieiti.bdproject.controller;

import com.isieiti.bdproject.dto.ReportDTO;
import com.isieiti.bdproject.dto.ReportPostDTO;
import com.isieiti.bdproject.entity.Employee;
import com.isieiti.bdproject.entity.Report;
import com.isieiti.bdproject.enums.ReportType;
import com.isieiti.bdproject.mapper.ReportMapper;
import com.isieiti.bdproject.service.EmployeeService;
import com.isieiti.bdproject.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/report")
public class ReportController {

    private final ReportMapper mapper;
    private final ReportService reportService;
    private final EmployeeService employeeService;

    @GetMapping("/{id}")
    public ReportDTO getReport(@PathVariable Long id) {
        return mapper.toReportDTO(reportService.getSingleReport(id));
    }

    @GetMapping
    public List<ReportDTO> getAllReports() {
        return mapper.toReportDTOs(reportService.getAllReports());
    }

    @GetMapping("/type")
    public List<ReportDTO> getAllReportsByType(@RequestParam(name = "type") ReportType type, @RequestParam(name = "status") boolean closed) {
        return mapper.toReportDTOs(reportService.getAllReportsByType(type, closed));
    }

    @GetMapping("/employee")
    public List<ReportDTO> getAllReportsByEmployee(@RequestParam(name = "employeeId") Long id) {
        Employee employee = employeeService.getSingleEmployee(id);
        return mapper.toReportDTOs(reportService.getAllReportsByEmployee(employee));
    }

    @PostMapping
    public ReportPostDTO addReport(@RequestBody @Valid ReportPostDTO reportPostDTO) {
        Employee employee = employeeService.getSingleEmployee(reportPostDTO.getEmployeeId());
        Report report = mapper.toReport(reportPostDTO);
        report.setEmployee(employee);
        return mapper.toReportPostDTO(reportService.addReport(report));
    }

    @PreAuthorize("hasAuthority('ADMIN') AND hasAuthority('MAINTAINER')")
    @PutMapping("/{id}")
    public void updateStatus(@PathVariable Long id){
        reportService.changeStatus(id);
    }

    @DeleteMapping("/{id}")
    public void deleteReport(@PathVariable Long id) {
        reportService.deleteReport(id);
    }
}
