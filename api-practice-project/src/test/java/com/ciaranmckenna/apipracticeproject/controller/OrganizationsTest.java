package com.ciaranmckenna.apipracticeproject.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebMvcTest(Organizations.class)
class OrganizationsTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testOrganizations() throws Exception {
        mockMvc.perform(get("/organizations"))
                .andExpect(status().isOk())
                .andExpect(view().name("organizations"))
                .andExpect(content().string(
                        containsString("Welcome to Organizations")));
    }
}