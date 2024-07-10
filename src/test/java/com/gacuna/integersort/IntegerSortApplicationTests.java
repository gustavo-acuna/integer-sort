package com.gacuna.integersort;

import com.gacuna.integersort.controller.SortingController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class IntegerSortApplicationTests {

    @Autowired
    private SortingController controller;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

}
