package com.gacuna.integersort.domain;

import java.util.Comparator;

public interface NumberSorting<E extends Number> {
    Comparator<E> getComparator();
}
