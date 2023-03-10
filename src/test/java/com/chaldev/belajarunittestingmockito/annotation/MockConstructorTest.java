package com.chaldev.belajarunittestingmockito.annotation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MockConstructorTest {

    @Mock
    private final List<String> list;

    MockConstructorTest(@Mock List<String> list) {
        this.list = list;
    }

    @Test
    void testConstructor() {
        list.add("Hello World Java Developer");

    }



}
