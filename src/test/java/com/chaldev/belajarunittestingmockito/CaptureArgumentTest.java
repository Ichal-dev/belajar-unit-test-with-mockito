package com.chaldev.belajarunittestingmockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CaptureArgumentTest {

    @Mock
    private Person person;

    @Test
    void testCapture() {

        when(person.getName(anyString())).thenReturn("success get listener person name");
        person.getName("Faisal");

        ArgumentCaptor<String> argumentCaptor= ArgumentCaptor.forClass(String.class);
        verify(person).getName(argumentCaptor.capture());

        Assertions.assertEquals("Faisal", argumentCaptor.getValue());
        System.out.println(argumentCaptor.getValue());

    }

}
