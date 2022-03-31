package com.ciaranmckenna.apipracticeproject.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Primary Key is auto generated and marked as ID
    private int applicationId;
    private String applicationName;

    @ManyToOne
    private Platform platform;

    @ManyToMany
    @JoinTable(name = "ORGANIZATION_APPLICATION", joinColumns = @JoinColumn(name = "APP_ID"), inverseJoinColumns = @JoinColumn(name = "ORG_ID"))
    private Set<Organization> organization = new HashSet<>();

    public Application() {
    }

    public Application(String applicationName) {
        this.applicationName = applicationName;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public Set<Organization> getOrganization() {
        return organization;
    }

    public void setOrganization(Set<Organization> organization) {
        this.organization = organization;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Application that = (Application) o;

        return applicationId == that.applicationId;
    }

    @Override
    public int hashCode() {
        return applicationId;
    }

    @Override
    public String toString() {
        return "Application{" +
                "applicationId=" + applicationId +
                ", applicationName='" + applicationName + '\'' +
                ", organization=" + organization +
                '}';
    }
}
