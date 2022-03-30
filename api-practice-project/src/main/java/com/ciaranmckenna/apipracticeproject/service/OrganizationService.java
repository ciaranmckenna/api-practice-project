package com.ciaranmckenna.apipracticeproject.service;

import com.ciaranmckenna.apipracticeproject.repository.OrganizationRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrganizationService {

    private final OrganizationRepository organizationsRepository;

    public OrganizationService(final OrganizationRepository organizationsRepository) {
        this.organizationsRepository = organizationsRepository;
    }

    public String getOrganizations(){
        return organizationsRepository.findByOrganization();
    }

    public String getOrganizationsId(Integer id){
        return organizationsRepository.findByOrganizationId(id);
    }
}
