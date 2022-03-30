package com.ciaranmckenna.apipracticeproject.repository;

import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class OrganizationRepository {

    public String findByOrganization(){
        return "organizations";
    }

    public String[] findByOrganizationId(String[] arr){
        //return generateOrganizationId(organizationId);
        arr = new String[]{};
        return arr;
        //return new UUID(1L, 1L);
    }

    /*public static String[] generateOrganizationId(final UUID organizationId){

        return new String[]{};
    }*/
}
