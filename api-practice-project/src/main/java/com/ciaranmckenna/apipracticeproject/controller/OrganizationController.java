package com.ciaranmckenna.apipracticeproject.controller;

import com.ciaranmckenna.apipracticeproject.service.OrganizationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrganizationController {

    public static final String ORGANIZATIONS = "/organizations";

    private final OrganizationService organizationService;

    public OrganizationController(final OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping(ORGANIZATIONS)
    public ResponseEntity<String> getOrganizations(){
        return ResponseEntity.ok(organizationService.getOrganizations());}
}
