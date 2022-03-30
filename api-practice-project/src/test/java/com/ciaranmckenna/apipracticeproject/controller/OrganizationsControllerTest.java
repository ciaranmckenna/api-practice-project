package com.ciaranmckenna.apipracticeproject.controller;

import com.ciaranmckenna.apipracticeproject.service.OrganizationService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.ciaranmckenna.apipracticeproject.controller.OrganizationController.ORGANIZATIONS_URL;
import static com.ciaranmckenna.apipracticeproject.controller.OrganizationController.ORGANIZATIONS_ID_URL;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(OrganizationController.class)
@AutoConfigureMockMvc
class OrganizationsControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private OrganizationService service;

    @Test
    void testGetOrganizations() throws Exception {
        // given
        String expectedResultInformation = "organizations";

        // when
        when(service.getOrganizations()).thenReturn(expectedResultInformation);

        // then
        mockMvc.perform(get(ORGANIZATIONS_URL))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString(expectedResultInformation)));
    }

    @Test
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
    }
}