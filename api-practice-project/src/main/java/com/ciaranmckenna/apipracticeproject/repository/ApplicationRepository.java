package com.ciaranmckenna.apipracticeproject.repository;

import com.ciaranmckenna.apipracticeproject.model.Application;
import com.ciaranmckenna.apipracticeproject.model.Organization;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationRepository extends CrudRepository<Application, Integer> {
}
