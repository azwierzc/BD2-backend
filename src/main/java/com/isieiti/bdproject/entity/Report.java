package com.isieiti.bdproject.entity;

import com.isieiti.bdproject.enums.ReportType;
import lombok.Data;

import javax.annotation.Nullable;
import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "creation_timestamp")
    private LocalDateTime creationTimestamp;

    @Column(name = "is_closed")
    private boolean closed;

    private String content;

    @Enumerated(STRING)
    private ReportType type;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
