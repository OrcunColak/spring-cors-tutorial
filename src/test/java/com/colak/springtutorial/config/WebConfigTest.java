package com.colak.springtutorial.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class WebConfigTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCorsConfiguration() throws Exception {
        mockMvc.perform(options("/hello") // Replace with the actual endpoint you want to test
                        .header(HttpHeaders.ORIGIN, "http://localhost:3000") // Set origin header
                        .header(HttpHeaders.ACCESS_CONTROL_REQUEST_METHOD, "GET")) // Set preflight method
                .andExpect(status().isOk()) // Expecting OK (200) response
                .andExpect(header().string(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "http://localhost:3000")) // Check allowed origin
                .andExpect(header().string(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "GET,POST,PUT,DELETE,OPTIONS")) // Check allowed methods
                // .andExpect(header().string("Access-Control-Allow-Headers", "*")) // Check allowed headers
                .andExpect(header().string(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true")); // Check credentials
    }
}
