package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class ProviderId implements Serializable {
    @Column(name="provider_id", nullable = false)
    private Integer providerId;
    @Column(name="equipment_type_id", nullable = false)
    private Integer equipmentId;

}
