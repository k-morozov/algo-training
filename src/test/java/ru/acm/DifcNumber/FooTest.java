package ru.acm.DifcNumber;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FooTest {
    private Foo foo = new Foo();
    @Test
    public void Test_1() {
        int number = 1;
        Pair result = foo.getMaxDifc(number);
        Pair expected = new Pair(1,1);
        assertEquals(result.num, expected.num);
        assertEquals(result.difc, expected.difc);
    }

    @Test
    public void Test_10() {
        int number = 10;
        Pair result = foo.getMaxDifc(number);
        Pair expected = new Pair(6,4);
        assertEquals(result.num, expected.num);
        assertEquals(result.difc, expected.difc);
    }

    @Test
    public void Test_100() {
        int number = 100;
        Pair result = foo.getMaxDifc(number);
        Pair expected = new Pair(60,12);
        assertEquals(result.num, expected.num);
        assertEquals(result.difc, expected.difc);
    }

    @Test
    public void Test_1000() {
        int number = 1000;
        Pair result = foo.getMaxDifc(number);
        Pair expected = new Pair(840,32);
        assertEquals(result.num, expected.num);
        assertEquals(result.difc, expected.difc);
    }

    @Test
    public void Test_10000() {
        int number = 10000;
        Pair result = foo.getMaxDifc(number);
        Pair expected = new Pair(7560,64);
        assertEquals(result.num, expected.num);
        assertEquals(result.difc, expected.difc);
    }

    @Test
    public void Test_1000018() {
        long number = 1000000000000000000l;
        Pair result = foo.getMaxDifc(number);
        Pair expected = new Pair(897612484786617600l,103680l);
        assertEquals(result.num, expected.num);
        assertEquals(result.difc, expected.difc);
    }

    @Test
    public void Test_10000018() {
        long number = 897612484786617600l;
        Pair result = foo.getMaxDifc(number);
        Pair expected = new Pair(897612484786617600l,103680l);
        assertEquals(result.num, expected.num);
        assertEquals(result.difc, expected.difc);
    }
}