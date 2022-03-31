package com.ciaranmckenna.apipracticeproject.controller;

import com.ciaranmckenna.apipracticeproject.repository.OrganizationRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrganizationController {

    private final OrganizationRepository organizationRepository;

    public OrganizationController(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @RequestMapping("/organizations")
    public String getOrganizations(Model model){

        model.addAttribute("organizations", organizationRepository.findAll());
        return "organizations/list";
    }

    @RequestMapping("/organizations")
    public String getOrganizationsById(Model model){

        model.addAttribute("organizations", organizationRepository.findAll());
        return "organizations/list";
    }

}
