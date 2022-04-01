package com.ciaranmckenna.apipracticeproject.controller;

import com.ciaranmckenna.apipracticeproject.service.OrganizationService;
import com.ciaranmckenna.apipracticeproject.service.OrganizationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrganizationController {

    @Autowired
    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }


    @RequestMapping("/organizations")
    public String getOrganizations(Model model){

        model.addAttribute("organizations", organizationService.getOrganizations());
        return "organizations/list";
    }

    /*@RequestMapping("/organizations/{id}")
    public String getOrganizationsById(@PathVariable String id, Model model){

        model.addAttribute("organizations", organizationRepository.findById(Integer.valueOf(id)));
        return "organizations/list";
    }*/

}
