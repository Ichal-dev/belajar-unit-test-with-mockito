package com.chaldev.belajarunittestingmockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

public class RealPartialMockTest {

    @Test
    void test() {
        Person mock = mock(Person.class);

        when(mock.trouble()).thenCallRealMethod();
    }
}
