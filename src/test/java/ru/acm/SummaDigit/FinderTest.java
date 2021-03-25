package ru.acm.SummaDigit;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class FinderTest {
    private final Finder finder = new Finder();
    private final String noSolution = "No solution";

    @Test
    void Sum_9_SumSq_81() {
        int summaDigit = 9;
        int summaSquare = 81;
        String result = finder.findNumber(summaDigit, summaSquare);
        String expected = "9";

        assertEquals(result, expected);
    }

    @Test
    void Sum_12_SumSq_9() {
        int summaDigit = 12;
        int summaSquare = 9;
        String result = finder.findNumber(summaDigit, summaSquare);
        String expected = noSolution;

        assertEquals(result, expected);
    }

    @Test
    void Sum_6_SumSq_10() {
        int summaDigit = 6;
        int summaSquare = 10;
        String result = finder.findNumber(summaDigit, summaSquare);
        String expected = "1122";

        assertEquals(result, expected);
    }

    @Test
    void Sum_7_SumSq_9() {
        int summaDigit = 7;
        int summaSquare = 9;
        String result = finder.findNumber(summaDigit, summaSquare);
        String expected = "111112";

        assertEquals(result, expected);
    }

    @Test
    void Sum_45_SumSq_285() {
        int summaDigit = 45;
        int summaSquare = 285;
        String result = finder.findNumber(summaDigit, summaSquare);
        String expected = "14667777";

        assertEquals(result, expected, "check that answer is min length (between some answers))");
    }

    @Test
    void Sum_456_SumSq_2120() {
        int summaDigit = 456;
        int summaSquare = 2120;
        String result = finder.findNumber(summaDigit, summaSquare);
        String expected = "1334444444444444444444444444444444444445555555555555555555555555555555555555555555555555555555555555";

        assertEquals(result, expected);
    }

    @Test
    void Sum_456_SumSq_4081() {
        int summaDigit = 456;
        int summaSquare = 4081;
        String result = finder.findNumber(summaDigit, summaSquare);
        String expected = noSolution;

        assertEquals(result, expected);
    }

    @Test
    void Sum_3_SumSq_3() {
        int summaDigit = 3;
        int summaSquare = 3;
        String result = finder.findNumber(summaDigit, summaSquare);
        String expected = "111";

        assertEquals(result, expected);
    }

    @Test
    void Sum_900_SumSq_8100() {
        int summaDigit = 900;
        int summaSquare = 8100;
        String result = finder.findNumber(summaDigit, summaSquare);
        String expected = "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999";

        assertEquals(result, expected);
    }

    @Test
    void Sum_456_SumSq_2119() {
        int summaDigit = 456;
        int summaSquare = 2119;
        String result = finder.findNumber(summaDigit, summaSquare);
        String expected = noSolution;

        assertEquals(result, expected);
    }

    @Test
    void Sum_456_SumSq_3456() {
        int summaDigit = 456;
        int summaSquare = 3456;
        String result = finder.findNumber(summaDigit, summaSquare);
        String expected = "2677777777777777777777777788888888888888888888888888888888888";

        assertEquals(result, expected);
    }

    @Test
    void Sum_901_SumSq_3456() {
        int summaDigit = 901;
        int summaSquare = 3456;
        String result = finder.findNumber(summaDigit, summaSquare);
        String expected = noSolution;

        assertEquals(result, expected);
    }

    @Test
    void Sum_M1_SumSq_3456() {
        int summaDigit = -1;
        int summaSquare = 3456;
        String result = finder.findNumber(summaDigit, summaSquare);
        String expected = noSolution;

        assertEquals(result, expected);
    }

    @Test
    void Sum_456_SumSq_8101() {
        int summaDigit = 456;
        int summaSquare = 8101;
        String result = finder.findNumber(summaDigit, summaSquare);
        String expected = noSolution;

        assertEquals(result, expected);
    }
    @Test
    void Sum_456_SumSq_M1() {
        int summaDigit = 456;
        int summaSquare = -1;
        String result = finder.findNumber(summaDigit, summaSquare);
        String expected = noSolution;

        assertEquals(result, expected);
    }

}