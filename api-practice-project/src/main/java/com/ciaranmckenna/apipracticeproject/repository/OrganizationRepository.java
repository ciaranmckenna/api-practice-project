package com.ciaranmckenna.apipracticeproject.repository;

import com.ciaranmckenna.apipracticeproject.model.Organization;
import org.springframework.data.repository.CrudRepository;

public interface OrganizationRepository extends CrudRepository<Organization, Integer> {
}
