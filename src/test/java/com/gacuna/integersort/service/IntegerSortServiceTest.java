package com.gacuna.integersort.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static com.gacuna.integersort.domain.IntegerSorting.BINARY;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class IntegerSortServiceTest {

    @InjectMocks
    private IntegerSortServiceImpl integerSortService;

    @Test
    void sortByBinary() {
        List<Integer> input = Arrays.asList(7, 2, 1, 9, 5, 3, 8, 25, 42);
        List<Integer> expectedOutput = Arrays.asList(1, 2, 8, 3, 5, 9, 7, 25, 42);

        List<Integer> actualOutput = integerSortService.sort(input, BINARY);

        assertEquals(expectedOutput, actualOutput);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void sort_empty_list(List<Integer> input) {
        List<Integer> expectedOutput = List.of();

        List<Integer> actualOutput = integerSortService.sort(input, BINARY);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void sort_numberSorting_is_null() {
        List<Integer> input = Arrays.asList(7, 2, 1, 9, 5, 3, 8, 25, 42);
        List<Integer> expectedOutput = Arrays.asList(7, 2, 1, 9, 5, 3, 8, 25, 42);

        List<Integer> actualOutput = integerSortService.sort(input, null);

        assertEquals(expectedOutput, actualOutput);
    }
}