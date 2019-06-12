package com.isieiti.bdproject.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

@Entity
@Data
@Table(name = "instruments")
public class Instrument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "last_check_timestamp")
    private LocalDateTime lastCheckTimestamp;

    @Column(name = "check_period")
    private LocalDateTime checkPeriod;

    @OneToMany(cascade = ALL, orphanRemoval = true, mappedBy = "instrument", fetch = LAZY)
    private List<InstrumentReservation> instrumentReservations;
}
