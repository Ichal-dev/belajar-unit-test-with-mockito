package com.chaldev.belajarunittestingmockito;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

public class Stubber {

    @Test
    void testStubVoidWithException() {
        List mockList = mock(List.class);
        doThrow(new RuntimeException()).when(mockList).clear();
        mockList.clear();
    }

    @Test
    void testStubDoReturn(){

        // spy itu sekan akan kita memanggil real object return CGLIB

        LinkedList linkedList = new LinkedList();
        List spy = spy(linkedList);

//        when(spy.get(0)).thenReturn("foo"); //error
        doReturn("foo").when(spy).get(0);



    }
}
