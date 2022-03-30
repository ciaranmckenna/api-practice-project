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
@Table(name = "platforms")
public class Platform {
    @Id
    @Column(name="PLATFORM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Primary Key is auto generated and marked as ID
    private int application_id;
    @Column(name="PLATFORM_NAME")
    private String application_name;
}
