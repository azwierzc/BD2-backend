package com.isieiti.bdproject.entity;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Table(name = "instrument_types")
public class InstrumentType {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;
}
