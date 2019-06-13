package com.karteladentare.kdsherbimetservice.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.karteladentare.kdsherbimetservice.domain.Sherbimi;
import com.karteladentare.kdsherbimetservice.service.SherbimiService;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.print.attribute.standard.Media;
import java.util.Arrays;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SherbimiControllerTest {

    @MockBean
    private SherbimiService sherbimiService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET /v1/sherbimet - Success (Return all resources)")
    public void testKtheTeGjithaSherbimet() throws Exception {

        when(sherbimiService.ktheTeGjithaSherbimet()).thenReturn(Arrays.asList(new Sherbimi(), new Sherbimi(), new Sherbimi()));

        mockMvc.perform(get("/v1/sherbimet")).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    @DisplayName("GET /v1/sherbimet - Success (Return single resource by id)")
    public void ktheSherbiminTest() throws Exception {

        Sherbimi sh = new Sherbimi();
        sh.setId(1L);

        when(sherbimiService.ktheSherbimin(1L)).thenReturn(sh);

        mockMvc.perform(get("/v1/sherbimet/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", equalTo(1)));
    }

    @Test
    @DisplayName("POST /v1/sherbimet - Success (Return 201 - Resource Created Successfully)")
    public void krijoSherbiminTest() throws Exception {
        // Setup mock
        Sherbimi sh = new Sherbimi();
        sh.setEmri("test");
        sh.setCmimi(25.0);
        sh.setId(2L);

        when(sherbimiService.shtoSherbimin(sh)).thenReturn(sh);

        //Perform request
        mockMvc.perform(post("/v1/sherbimet")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(new ObjectMapper().writeValueAsString(sh)))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("PUT /v1/sherbimet/1 - Success (Return 200)")
    public void perditesoSherbiminTest() throws Exception {
        //Setup mock
        Sherbimi sh = new Sherbimi();
        sh.setEmri("test");
        sh.setCmimi(10.0);
        sh.setId(1L);

        when(sherbimiService.perditesoSherbimin(sh)).thenReturn(sh);

        //Perform request
        mockMvc.perform(put("/v1/sherbimet/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(sh)))
                        .andExpect(status().isOk());

    }

    @Test
    @DisplayName("DELETE /v1/sherbimet/1 - Success")
    public void fshijeSherbiminTest() throws Exception {

        Sherbimi sh = new Sherbimi();
        sh.setId(1L);
        doNothing().when(sherbimiService).fshijSherbimin(1L);

        mockMvc.perform(delete("/v1/sherbimet/{id}", 1))
                .andExpect(status().isNoContent());
    }

}


