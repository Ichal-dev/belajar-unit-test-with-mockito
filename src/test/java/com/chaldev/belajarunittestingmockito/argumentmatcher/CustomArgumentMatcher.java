package com.chaldev.belajarunittestingmockito.argumentmatcher;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

class CustomArgumentMatcher implements ArgumentMatcher<List> {
    @Override
    public boolean matches(List list) {
        return list.size() == 2;
    }

    @Override
    // print verification error
    public String toString() {
        return "[list of 2 elements]";
    }

    @Test
    void testCustomArgumentMatcherExample() {
        List mock = mock(List.class);
        when(mock.addAll(argThat(new CustomArgumentMatcher()))).thenReturn(true);
        mock.addAll(Arrays.asList("one", "two"));

        verify(mock).addAll(argThat(new CustomArgumentMatcher()));
    }

    @Test
    void testCustomArgumentMatcherLamda() {
        List mock = mock(List.class);
        mock.addAll(Arrays.asList("One", "Two"));
        verify(mock).addAll(argThat(list -> list.size() == 2));

    }

}
