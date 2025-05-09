package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "tower")
@Getter
@Setter
public class Tower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    private String location;
    private String height;
    @Column(name="installation_date")
    private String installationDate;
    @OneToMany
    @JoinColumn(name = "state_id")
    private TowerState towerState;
}
