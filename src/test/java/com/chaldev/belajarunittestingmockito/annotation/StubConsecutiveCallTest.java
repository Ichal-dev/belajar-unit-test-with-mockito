package com.chaldev.belajarunittestingmockito.annotation;
import com.chaldev.belajarunittestingmockito.Calculator;
import org.junit.jupiter.api.Test;


import static org.mockito.Mockito.*;

public class StubConsecutiveCallTest {

    @Test
    void testConsecutiveCallSample1() {

        Calculator mock = mock(Calculator.class);

        when(mock.sum(2,3))
                .thenReturn(6)
                .thenReturn(10)
                .thenReturn(12)
                .thenThrow(new RuntimeException());

        System.out.println(mock.sum(2,3));
        System.out.println(mock.sum(2,3));
        System.out.println(mock.sum(2,3));
        System.out.println(mock.sum(2,3)); // throw exception

    }

    @Test
    void testConsecutiveCallSample2() {

        Calculator mock = mock(Calculator.class);

        when(mock.sum(anyInt(),anyInt()))
                .thenReturn(20,30,40,50)
                        .thenThrow(new RuntimeException());

        System.out.println(mock.sum(10,10));
        System.out.println(mock.sum(10,10));
        System.out.println(mock.sum(10,10));
        System.out.println(mock.sum(10,10));
        System.out.println(mock.sum(10,10));
    }
}
