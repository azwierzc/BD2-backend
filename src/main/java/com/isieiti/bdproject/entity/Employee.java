package com.isieiti.bdproject.entity;

import com.isieiti.bdproject.enums.MedicalEmployeeRole;
import lombok.Data;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.EnumType.STRING;

import java.lang.invoke.LambdaConversionException;
import java.util.List;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Table(name = "medical_employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private String prefix;

    @Enumerated(STRING)
    private MedicalEmployeeRole type;

    @ManyToOne
    @JoinColumn(name = "ward_id")
    private Ward ward;

    @OneToMany(mappedBy = "employee")
    private List<Report> reports;

    @OneToMany(cascade = ALL, orphanRemoval = true, mappedBy = "employee", fetch = LAZY)
    //@JoinColumn(name = "employee_id")
    private List<InstrumentReservation> instrumentReservations;

    @OneToMany(cascade = ALL, orphanRemoval = true, mappedBy = "employee", fetch = LAZY)
    //@JoinColumn(name = "employee_id")
    private List<RoomReservation> roomReservations;
}
