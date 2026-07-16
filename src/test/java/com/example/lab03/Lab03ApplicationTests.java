package com.example.lab03;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Basic test — ตรวจสอบว่า Spring Application Context โหลดได้ปกติ
 * รันด้วย: mvn test
 */
@SpringBootTest
@AutoConfigureMockMvc
class Lab03ApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
        // ถ้า Spring Boot start ได้โดยไม่ error — test ผ่าน
    }

    @Test
    void helloEndpointReturnsStudentInfo() throws Exception {
        mockMvc.perform(get("/api/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Narathaip Phromprakai")))
                .andExpect(content().string(containsString("673380054")))
                .andExpect(content().string(containsString("sec: 1")));
    }

    @Test
    void infoEndpointReturnsProjectInfo() throws Exception {
        mockMvc.perform(get("/api/info"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Project: Lab03 Spring Boot")))
                .andExpect(content().string(containsString("Narathaip Phromprakai")))
                .andExpect(content().string(containsString("Section: 1")));
    }

    @Test
    void statusEndpointReturnsOkMessage() throws Exception {
        mockMvc.perform(get("/api/status"))
                .andExpect(status().isOk())
                .andExpect(content().string("Server is running OK"));
    }
}
