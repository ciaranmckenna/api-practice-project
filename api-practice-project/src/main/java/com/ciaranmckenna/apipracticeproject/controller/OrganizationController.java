package com.ciaranmckenna.apipracticeproject.controller;

import com.ciaranmckenna.apipracticeproject.repository.OrganizationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
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

    /*@RequestMapping("/organizations/{id}")
    public String getOrganizationsById(@PathVariable String id, Model model){

        model.addAttribute("organizations", organizationRepository.findById(Integer.valueOf(id)));
        return "organizations/list";
    }*/

}
