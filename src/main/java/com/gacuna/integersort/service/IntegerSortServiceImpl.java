package com.gacuna.integersort.service;

import com.gacuna.integersort.domain.NumberSorting;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class IntegerSortServiceImpl implements SortService<Integer> {


    @Override
    public List<Integer> sort(List<Integer> numbers, NumberSorting<Integer> sorting) {
        final Stream<Integer> stream = Optional.ofNullable(numbers)
                .orElseGet(List::of)
                .stream();

        return Optional.ofNullable(sorting)
                .map(NumberSorting::getComparator)
                .map(comparator -> stream.sorted(comparator).toList())
                .orElseGet(stream::toList);
    }
}
