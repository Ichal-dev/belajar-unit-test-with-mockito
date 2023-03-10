package com.chaldev.belajarunittestingmockito.driven;
import com.chaldev.belajarunittestingmockito.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DrivenBddMockitoTest {

    @Mock
    private Calculator calculator;
    @Test
    void shouldDrivenTest() {

        //give
        given(calculator.sum(anyInt(), anyInt())).willReturn(10);

        //when
        calculator.sum(10,10);
        calculator.sum(10,10);

        //then
        then(calculator).should(times(2)).sum(anyInt(),anyInt());
    }
}
