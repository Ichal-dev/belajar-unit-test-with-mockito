package com.chaldev.belajarunittestingmockito.annotation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MockMethodParameterTest {

    @Test
    void testMethodParameter(@Mock List<Integer> list) {
        list.add(1000);
    }
}
