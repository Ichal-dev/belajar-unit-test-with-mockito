package com.chaldev.belajarunittestingmockito.annotation;

import com.chaldev.belajarunittestingmockito.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatcher;
import org.mockito.Captor;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MockCaptureTest {

    @Captor
    private ArgumentCaptor<String> argumentCaptor;

    @Test
    void testCapture() {
        Person mock = mock(Person.class);

        //given
        given(mock.getName(anyString())).willReturn("Faisal");

        //when
        Assertions.assertEquals("Faisal", mock.getName("Faisal"));
        then(mock).should(timeout(1)).getName(argumentCaptor.capture());

        //then
        Assertions.assertEquals("Faisal", argumentCaptor.getValue());
        System.out.println(argumentCaptor.getValue());

    }
}
