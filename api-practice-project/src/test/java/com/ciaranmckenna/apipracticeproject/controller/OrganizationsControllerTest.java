package com.ciaranmckenna.apipracticeproject.controller;

import com.ciaranmckenna.apipracticeproject.model.Organization;
import com.ciaranmckenna.apipracticeproject.service.OrganizationService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebMvcTest(OrganizationController.class)
@AutoConfigureMockMvc
class OrganizationsControllerTest {

@Autowired
    private MockMvc mockMvc;
    @MockBean
    private OrganizationService service;

    @Mock
    OrganizationService organizationService;

    @Mock
    Model model;

    OrganizationController organizationController;

    @Test
    void testMockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(organizationController).build();

        mockMvc.perform(get("/organizations"))
                .andExpect(status().isOk())
                .andExpect(view().name("list"));
    }


    @Test
    void testGetOrganizations() throws Exception {
        // given
        Organization organization = new Organization("Organization Company");
        organization.setOrganizationId(1);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(organizationController).build();

        // when
        when(organizationService.findById(anyInt())).thenReturn(organization);

        // then
        mockMvc.perform(get("organizations/list/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString("Organization Company")));
    }

   /* @Test
    void testGetOrganizationsById() throws Exception {
        // given
        int id = 1;
        Integer organizationId = 1;
        String expectedResultInformation = Integer.toString(id);

        // when
        when(service.getOrganizationsId(id)).thenReturn(expectedResultInformation);

        // then
        mockMvc.perform(get(ORGANIZATIONS_ID_URL, organizationId))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString(expectedResultInformation))); // failing as "" is returned and it expects "1"
    }*/

}
