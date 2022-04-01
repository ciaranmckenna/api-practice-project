package com.ciaranmckenna.apipracticeproject.repository;

import com.ciaranmckenna.apipracticeproject.model.Organization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization, Integer> {
}
