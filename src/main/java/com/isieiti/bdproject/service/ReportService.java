package com.isieiti.bdproject.service;

import com.isieiti.bdproject.entity.Report;
import com.isieiti.bdproject.exception.ResourceNotFoundException;
import com.isieiti.bdproject.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final ReportRepository repository;

    @Transactional(readOnly = true)
    public Report getSingleReport(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Report", "id", id));
    }

    @Transactional(readOnly = true)
    public List<Report> getAllReports() {
        return repository.findAll();
    }

    @Transactional
    public Report addReport(Report report) {
        return repository.save(report);
    }

    @Transactional
    public void deleteReport(Long id) {
        repository.deleteById(id);
    }
}
