package com.gacuna.integersort.controller;

import com.gacuna.integersort.domain.IntegerSorting;
import com.gacuna.integersort.service.SortService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v0/sort")
@RequiredArgsConstructor
@Tag(name = "SortService", description = "Servicio para ordenar números")
public class SortingController {

    private final SortService<Integer> integerSortService;

    @PostMapping("/integer/binary")
    @Operation(summary = "Ordenar números enteros por su representación binaria")
    public ResponseEntity<List<Integer>> sortNumbers(
            @RequestBody List<Integer> numbers) {
        List<Integer> sortedNumbers = integerSortService.sort(numbers, IntegerSorting.BINARY);
        return ResponseEntity.ok(sortedNumbers);

    }
}
