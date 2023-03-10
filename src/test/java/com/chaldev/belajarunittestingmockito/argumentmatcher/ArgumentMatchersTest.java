package com.chaldev.belajarunittestingmockito.argumentmatcher;

import com.chaldev.belajarunittestingmockito.Employee;
import com.chaldev.belajarunittestingmockito.Foo;
import com.chaldev.belajarunittestingmockito.Merchant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

public class ArgumentMatchersTest {

    // when same verify() method call
    // when method for all method return value

    // verify harus ada method yang di panggil kalau tidak maka terjadi zero intercation exception

    @Test
    void testArgumentMatcherAnyInteger() {
        List mockedList = mock(List.class);
        when(mockedList.get(anyInt())).thenReturn("element");

        // return value this is anyInt
        System.out.println(mockedList.get(100));
        verify(mockedList).get(anyInt());
    }


    @Test
    void testArgumentMatcherAnyBoolean() {

        Foo mock = mock(Foo.class);

        when(mock.getFoo(anyBoolean())).thenReturn("get foo running");
        System.out.println(mock.getFoo(null)); // this is null

        when(mock.getFoo(anyBoolean())).thenReturn("get foo running");
        System.out.println(mock.getFoo(true)); // return value this correct true /ok

        when(mock.getFoo(isNull())).thenReturn("get foo running");
        System.out.println(mock.getFoo(isNull())); // return this value isNull correct / ok

    }

    @Test
    void testArgumentMatcherEquals() {
        Employee mock = mock(Employee.class);


        mock.getEmployee(24,"Faisal", "Hello Employee");

//        verify(mock).getEmployee(anyInt(), anyString(), "Hello Employee"); // error expected 3 tapi yang ke record 2
        verify(mock).getEmployee(anyInt(), anyString(), eq("Hello Employee"));

    }

    @Test
    void testArgumentMatcherAnyLong() {
        Merchant mock = mock(Merchant.class);

        when(mock.payment(anyLong())).thenReturn("success melakukan pembayaran");

        Assertions.assertNotNull(mock);
        Assertions.assertSame("success melakukan pembayaran",mock.payment(anyLong()));

    }

    @Test
    void testArgumentMatcherIterable() {
        Merchant mock = mock(Merchant.class);

        List<String> merchantEnum = List.of(
                "Pembayaran",
                "Verifikasi",
                "Not Verifikasi"
        );


        mock.paymentIterable(merchantEnum);
        verify(mock).paymentIterable(anyIterable());

    }
}

