package com.ciaranmckenna.apipracticeproject.service;

import com.ciaranmckenna.apipracticeproject.model.Organization;
import com.ciaranmckenna.apipracticeproject.repository.OrganizationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class OrganizationServiceImpl implements OrganizationService{

    private final OrganizationRepository organizationRepository;

    public OrganizationServiceImpl(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    public Set<Organization> getOrganizations() {
        Set<Organization> organizationSet = new HashSet<>();
        organizationRepository.findAll().iterator().forEachRemaining(organizationSet::add);
        return organizationSet;
    }

    @Override
    public Organization findById(Integer I) {

        Optional<Organization> organizationOptional = organizationRepository.findById(I);
        if (organizationOptional.isEmpty()) {
            throw new RuntimeException("Organization not found");
        }
        return organizationOptional.get();
    }
}
