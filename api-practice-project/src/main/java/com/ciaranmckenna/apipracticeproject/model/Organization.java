package com.ciaranmckenna.apipracticeproject.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "organizations")
public class Organization {
    @Id
    @Column(name="ORG_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Primary Key is auto generated and marked as ID
    private int organization_id;
    @Column(name="ORG_NAME")
    private String organization_name;
}
