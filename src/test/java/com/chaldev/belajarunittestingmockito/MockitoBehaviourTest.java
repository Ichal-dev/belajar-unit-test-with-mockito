package com.chaldev.belajarunittestingmockito;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

public class MockitoBehaviourTest {

    @Test
    void testMockito() {
        // mock object tiruan this good :)
        List mockList = mock(List.class);


        mockList.add("Hello World");
        mockList.clear();

        //verification mock
        verify(mockList).add("Hello World");
        verify(mockList).clear();

    }

    @Test
    void testMockitoStubbing(){
        LinkedList mockedList = mock(LinkedList.class);

        when(mockedList.get(0)).thenReturn("Hello World");
        when(mockedList.get(1)).thenThrow(new RuntimeException());
        System.out.println(mockedList.get(0));
        System.out.println(mockedList.get(1));
        // null because mock primitive wrapper value or empty collection this is important
        // karena mock stubbing akan dieksekusi sebelum verify di invoked. semua method mengembalikan value when()
        // lebih baik method yang tidak digunakan di clear sja berlebihan / mubazir

        System.out.println(mockedList.get(999)); // this is null when object this not invoked important

        verify(mockedList).get(0);

    }

    @Test
    void testMakingSureInteractionNever() {
        List mockList = mock(List.class);

        mockList.add("One");

        verify(mockList).add("One");
//        verify(mockList).add("Two"); // error see below
        verify(mockList, never()).add("two");
    }

    @Test
    void testFindingRedundantInvocation() {
        Collection collectionMock = mock(Collection.class);

        collectionMock.add("Ichal");
        collectionMock.add("Cical");

        verify(collectionMock).add("Ichal");

        //verification fail
//        verifyNoMoreInteractions(collectionMock);

    }
}
