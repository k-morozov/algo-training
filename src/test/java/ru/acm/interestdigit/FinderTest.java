package ru.acm.interestdigit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FinderTest {
    private Finder finder = new Finder();

    @Test
    public void Test3and7() {
        long left = 3;
        long right = 7;
        long result = finder.getCountInterestNumbers(left, right);
        long expected = 4;
        assertEquals(result, expected);
    }

    @Test
    public void Test2and2() {
        long left = 2;
        long right = 2;
        long result = finder.getCountInterestNumbers(left, right);
        long expected = 1;
        assertEquals(result, expected);
    }

    @Test
    public void Test77and1010() {
        long left = 77;
        long right = 1010;
        long result = finder.getCountInterestNumbers(left, right);
        long expected = 924;
        assertEquals(result, expected);
    }

    @Test
    public void Test10and100() {
        long left = 10;
        long right = 100;
        long result = finder.getCountInterestNumbers(left, right);
        long expected = 86;
        assertEquals(result, expected);
    }

    @Test
    public void Test17and500() {
        long left = 17;
        long right = 500;
        long result = finder.getCountInterestNumbers(left, right);
        long expected = 476;
        assertEquals(result, expected);
    }

    @Test
    public void TestandLarge1() {
        long left = 1000;
        long right = 100000000000l;
//        long result = finder.getCountInterestNumbers(left, right);
//        long expected = 99999971585l;
//        assertEquals(result, expected);
    }
}