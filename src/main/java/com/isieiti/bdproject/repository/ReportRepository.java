package com.isieiti.bdproject.repository;

import com.isieiti.bdproject.entity.Report;
import com.isieiti.bdproject.enums.ReportType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

    List<Report> findAllByTypeAndClosedOrderByCreationTimestamp(ReportType type, boolean closed);
}
