package com.chaldev.belajarunittestingmockito;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.util.List;

import static org.mockito.Mockito.*;
public class VerificationInOrderTest {

    @Test
    void testInOrderVerify() {
        // Single mock order
        List mockList = mock(List.class);

        mockList.add("fooFirst");
        mockList.add("fooSecond");

        InOrder inOrder = inOrder(mockList);

        inOrder.verify(mockList).add("fooFirst");
        inOrder.verify(mockList).add("fooSecond");

    }

    @Test
    void testMultipleOrderVerify() {
        // multiple mock order
        List fooFirst = mock(List.class);
        List fooSecond = mock(List.class);

        fooFirst.add("fooFirst");
        fooSecond.add("fooSecond");

        InOrder inOrder = inOrder(fooFirst, fooSecond);

        inOrder.verify(fooFirst).add("fooFirst");
        inOrder.verify(fooSecond).add("fooSecond");

    }
}
