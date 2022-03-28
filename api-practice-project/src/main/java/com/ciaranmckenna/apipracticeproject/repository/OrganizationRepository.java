package com.ciaranmckenna.apipracticeproject.repository;

import org.springframework.stereotype.Repository;

@Repository
public class OrganizationRepository {

    public String findByOrganization(){
        return "organizations";
    }
}
