package com.ciaranmckenna.apipracticeproject.service;

import com.ciaranmckenna.apipracticeproject.model.Organization;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface OrganizationService {

    Set<Organization> getOrganizations();

    Organization findById(Integer I);
}
