package com.cisetech.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "company_info")
@EqualsAndHashCode(callSuper = true)
public class CompanyInfo extends BaseEntity {

    @Column(name = "company_name", nullable = false, length = 200)
    private String companyName;

    @Column(name = "short_name", length = 100)
    private String shortName;

    @Column(name = "stock_code", length = 50)
    private String stockCode;

    @Column(name = "logo_url", length = 500)
    private String logoUrl;

    @Column(name = "slogan", length = 200)
    private String slogan;

    @Column(name = "core_concept", length = 200)
    private String coreConcept;

    @Column(name = "brand_concept", length = 200)
    private String brandConcept;

    @Column(name = "service_philosophy", length = 200)
    private String servicePhilosophy;

    @Column(name = "founded_year")
    private Integer foundedYear;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "vision", columnDefinition = "TEXT")
    private String vision;

    @Column(name = "mission", columnDefinition = "TEXT")
    private String mission;

    @Column(name = "values", columnDefinition = "TEXT")
    private String values;

    @Column(name = "tech_stack", columnDefinition = "TEXT")
    private String techStack;

    @Column(name = "service_industries", columnDefinition = "TEXT")
    private String serviceIndustries;

    @Column(name = "city_coverage", length = 100)
    private String cityCoverage;

    @Column(name = "employee_count", length = 50)
    private String employeeCount;

    @Column(name = "customer_count", length = 50)
    private String customerCount;

    @Column(name = "contact_phone", length = 50)
    private String contactPhone;

    @Column(name = "contact_email", length = 100)
    private String contactEmail;

    @Column(name = "address", length = 500)
    private String address;

    @Column(name = "copyright", length = 200)
    private String copyright;

    @Column(name = "icp", length = 100)
    private String icp;
}
