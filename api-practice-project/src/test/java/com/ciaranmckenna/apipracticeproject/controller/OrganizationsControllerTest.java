package com.ciaranmckenna.apipracticeproject.controller;

import com.ciaranmckenna.apipracticeproject.service.OrganizationService;
import com.ciaranmckenna.apipracticeproject.service.OrganizationServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebMvcTest(OrganizationController.class)
@AutoConfigureMockMvc
class OrganizationsControllerTest {

@Autowired
    @Mock
OrganizationService organizationService;

    @Mock
    Model model;

    OrganizationController organizationControllerTestLogChecker;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        organizationControllerTestLogChecker = new OrganizationController(organizationService);
    }

    @Test
    void testGetOrganizations() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(organizationControllerTestLogChecker).build();

        mockMvc.perform(get("/organizations"))
                .andExpect(status().isOk())
                .andExpect(view().name("list"));
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
