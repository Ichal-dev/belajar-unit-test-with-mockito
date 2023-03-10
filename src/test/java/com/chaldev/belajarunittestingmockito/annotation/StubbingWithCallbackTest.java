package com.chaldev.belajarunittestingmockito.annotation;

import com.chaldev.belajarunittestingmockito.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.Arrays;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class StubbingWithCallbackTest {

    @Mock
    private Calculator calculator;

    @Test
    void test() {
        when(calculator.sum(anyInt(),anyInt())).thenAnswer(
                new Answer<Object>() {
                    @Override
                    public Object answer(InvocationOnMock invocation) throws Throwable {
                        Object[] arguments = invocation.getArguments();
                        Object mock = invocation.getMock();
                        return 40 + arguments.length;
                    }
                }
        );
        System.out.println(calculator.sum(anyInt(),anyInt()));
    }
}
