package com.chaldev.belajarunittestingmockito.annotation;

import com.chaldev.belajarunittestingmockito.Bar;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MockCreationsTest {

    @Mock
    private Bar bar;

    @Test
    void testMockCreation() {
        bar.getBar();
    }
}
