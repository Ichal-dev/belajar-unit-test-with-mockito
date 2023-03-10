package com.chaldev.belajarunittestingmockito;

import ch.qos.logback.classic.spi.EventArgUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Duration;

import static org.mockito.BDDMockito.*;

public class ConcurrentTimeoutTest {


    @Test
    void test() {


        Calculator mock = mock(Calculator.class);

        //given
        given(mock.sum(anyInt(),anyInt())).willReturn(20);
        given(mock.sum(anyInt(),anyInt())).willReturn(40);

        //when
        mock.sum(10,10);
        mock.sum(20,20);

        verify(mock, timeout(100).times(1)).sum(10,10);
        verify(mock, timeout(100).times(1)).sum(20,20);

        //then

    }
}
