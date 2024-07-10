package com.gacuna.integersort.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;


@Getter
@RequiredArgsConstructor
public enum IntegerSorting implements NumberSorting<Integer> {

    BINARY(Comparator.comparingInt(Integer::bitCount).thenComparingInt(n -> n));

    private final Comparator<Integer> comparator;

}
