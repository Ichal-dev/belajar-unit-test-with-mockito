package com.chaldev.belajarunittestingmockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;

import static org.mockito.Mockito.*;

public class VerifyExactOfInvocationTest {

    @Test
    void testExactVerifyInvocation() {
        List mockList = mock(List.class);

        //One Call
        mockList.add("One");

        //Two Call
        mockList.add("Two");
        mockList.add("Two");

        //Three Call
        mockList.add("three");
        mockList.add("three");
        mockList.add("three");

        // invocation one call
        verify(mockList).add("One"); //same 1 times
        verify(mockList, times(1)).add("One");

        // invocation two call
        verify(mockList,times(2)).add("Two");
        // invocation three call
        verify(mockList, times(3)).add("three");

        // invocation never tidak pernah di panggil is alias 0 times
        verify(mockList, never()).add("never happened");

    }

    @Test
    void testExactVerifyInvocationAtLeastOrAtMost() {
        List mockList = mock(List.class);

        //One Call
        mockList.add("One");

        //Two Call
        mockList.add("Two");
        mockList.add("Two");

        //Three Call
        mockList.add("three");
        mockList.add("three");
        mockList.add("three");

        verify(mockList, atLeast(1)).add("One");
        verify(mockList, atMostOnce()).add("One");
        verify(mockList, atLeastOnce()).add("One");
        verify(mockList, atLeast(2)).add("three");
        verify(mockList, atMost(5)).add("three");
    }
}
