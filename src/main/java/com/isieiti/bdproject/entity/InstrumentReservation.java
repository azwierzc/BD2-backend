package com.isieiti.bdproject.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Table(name = "instrument_reservations")
public class InstrumentReservation {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "start_timestamp")
    private LocalDateTime startTimestamp;

    @Column(name = "end_timestamp")
    private LocalDateTime endTimestamp;

    @ManyToOne()
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne()
    @JoinColumn(name = "instrument_id")
    private Instrument instrument;
}
