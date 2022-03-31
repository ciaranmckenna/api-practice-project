package com.ciaranmckenna.apipracticeproject.config;

import com.ciaranmckenna.apipracticeproject.model.Application;
import com.ciaranmckenna.apipracticeproject.model.Organization;
import com.ciaranmckenna.apipracticeproject.model.Platform;
import com.ciaranmckenna.apipracticeproject.repository.ApplicationRepository;
import com.ciaranmckenna.apipracticeproject.repository.OrganizationRepository;
import com.ciaranmckenna.apipracticeproject.repository.PlatformRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabasePersistenceConfig implements CommandLineRunner {

    private final OrganizationRepository organizationRepository;
    private final ApplicationRepository applicationRepository;
    private final PlatformRepository platformRepository;

    public DatabasePersistenceConfig(OrganizationRepository organizationRepository, ApplicationRepository applicationRepository, PlatformRepository platformRepository) {
        this.organizationRepository = organizationRepository;
        this.applicationRepository = applicationRepository;
        this.platformRepository = platformRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Organization organizationA = new Organization("Organization_A");
        Application applicationA = new Application("Application_A");
        Platform platformA = new Platform("Platform_A");
        platformRepository.save(platformA);

        Organization organizationB = new Organization("Organization_B");
        Application applicationB = new Application("Application_B");

        organizationA.getApplications().add(applicationA);
        applicationA.getOrganization().add(organizationA);

        applicationA.setPlatform(platformA);
        platformA.getApplications().add(applicationA); //

        organizationRepository.save(organizationA);
        applicationRepository.save(applicationA);
        platformRepository.save(platformA);

        organizationB.getApplications().add(applicationB);
        applicationB.getOrganization().add(organizationB);

        organizationRepository.save(organizationB);
        applicationRepository.save(applicationB);

        // LOGGING CODE FOR REFERENCE
        System.out.println("Started in DPC");
        System.out.println("Number of Organizations " + organizationRepository.count());
        System.out.println("Number of Applications " + applicationRepository.count());
        System.out.println("Number of Platforms " + platformRepository.count());

    }
}
