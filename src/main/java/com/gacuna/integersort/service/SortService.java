package com.gacuna.integersort.service;

import com.gacuna.integersort.domain.NumberSorting;

import java.util.List;

public interface SortService<E extends Number> {
    List<E> sort(List<E> numbers, NumberSorting<E> sorting);
}
