package com.ciaranmckenna.apipracticeproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Platform {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Primary Key is auto generated and marked as ID
    private Integer platformId;

    private String platformName;

    @OneToMany
    @JoinColumn(name = "platform_id")
    private Set<Application> applications = new HashSet<>();

    public Platform() {
    }

    public Platform(String platformName) {
        this.platformName = platformName;
    }

    public Integer getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Integer platformId) {
        this.platformId = platformId;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public Set<Application> getApplications() {
        return applications;
    }

    public void setApplications(Set<Application> applications) {
        this.applications = applications;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Platform platform = (Platform) o;

        return platformId != null ? platformId.equals(platform.platformId) : platform.platformId == null;
    }

    @Override
    public int hashCode() {
        return platformId != null ? platformId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Platform{" +
                "platformId=" + platformId +
                ", platformName='" + platformName + '\'' +
                '}';
    }
}
