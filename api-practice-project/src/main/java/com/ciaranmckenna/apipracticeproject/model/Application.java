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
@Table(name = "applications")
public class Application {
    @Id
    @Column(name="APP_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Primary Key is auto generated and marked as ID
    private int application_id;
    @Column(name="APP_NAME")
    private String application_name;
}
