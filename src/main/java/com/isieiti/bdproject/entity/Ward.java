package com.isieiti.bdproject.entity;

import lombok.Data;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Table(name = "wards")
public class Ward {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = ALL, orphanRemoval = true)
    @JoinColumn(name = "ward_id")
    private List<Employee> employees;
}
