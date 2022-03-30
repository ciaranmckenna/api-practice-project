package com.ciaranmckenna.apipracticeproject.controller;

import com.ciaranmckenna.apipracticeproject.service.OrganizationService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class OrganizationController {
    // endpoints
    public static final String ORGANIZATIONS_URL = "/organizations";
    public static final String ORGANIZATIONS_ID_URL = "/organizations/{id}";

    private final OrganizationService organizationService;

    public OrganizationController(final OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping(ORGANIZATIONS_URL)
    public ResponseEntity<String> getOrganizations(){
        return ResponseEntity.ok(organizationService.getOrganizations());}

    @GetMapping(value = ORGANIZATIONS_ID_URL, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getOrganizationsId(@PathVariable int id, final Integer organizationId ) {
        return ResponseEntity.ok(organizationService.getOrganizationsId(organizationId));}

}
