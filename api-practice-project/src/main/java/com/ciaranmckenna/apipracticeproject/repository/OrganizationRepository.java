package com.ciaranmckenna.apipracticeproject.repository;

import org.springframework.stereotype.Repository;

@Repository
public class OrganizationRepository {

    public String findByOrganization(){
        return "organizations";
    }

    public String findByOrganizationId(Integer id){ // using Integer as int was failing on optional

        return Integer.toString(id);
    }

}
