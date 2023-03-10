package com.chaldev.belajarunittestingmockito.annotation;

import com.chaldev.belajarunittestingmockito.Bar;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

@MockitoSettings(strictness = Strictness.STRICT_STUBS)
public class MockCreationConfigureTest {

    @Mock
    private Bar bar;

    @Test
    void testMockConfigurer() {
        bar.getBar();
    }
}
