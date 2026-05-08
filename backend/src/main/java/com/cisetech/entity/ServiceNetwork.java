package com.cisetech.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "service_networks")
@EqualsAndHashCode(callSuper = true)
public class ServiceNetwork extends BaseEntity {

    @Column(name = "city", nullable = false, length = 100)
    private String city;

    @Column(name = "region", length = 100)
    private String region;

    @Column(name = "address", length = 500)
    private String address;

    @Column(name = "phone", length = 50)
    private String phone;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "is_headquarters")
    private Boolean isHeadquarters = false;

    @Column(name = "sort_order")
    private Integer sortOrder = 0;
}
