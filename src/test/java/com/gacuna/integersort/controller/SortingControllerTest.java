package com.gacuna.integersort.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gacuna.integersort.domain.NumberSorting;
import com.gacuna.integersort.service.SortService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(SortingController.class)
class SortingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SortService<Integer> integerSortService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testSortNumbers() throws Exception {
        // Given
        List<Integer> inputNumbers = List.of(7, 2, 1, 9, 5, 3, 8, 25, 42);
        List<Integer> expectedSortedNumbers = List.of(1, 2, 8, 3, 5, 9, 7, 25, 42);

        when(integerSortService.sort(any(List.class), any(NumberSorting.class))).thenReturn(expectedSortedNumbers);

        // When & Then
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v0/sort/integer/binary")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(inputNumbers)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(objectMapper.writeValueAsString(expectedSortedNumbers)));
    }
}
