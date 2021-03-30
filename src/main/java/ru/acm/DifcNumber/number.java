package ru.acm.DifcNumber;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Scanner;

public class number {
    public static void main(String[] args) {
//        Stream stream = new Stream();
        Scanner stream = new Scanner(System.in);
        long count = stream.nextLong();

        Foo foo = new Foo();
        for (int i = 0; i < count; i++) {
            long number = stream.nextLong();
            Pair result = foo.getMaxDifc(number);
//            stream.getOut().println(result.num + " " + result.difc);
//            stream.getOut().flush();
            System.out.println(result.num + " " + result.difc);
        }
    }
}

class Pair {
    public final long num;
    public final long difc;

    Pair(long left, long right) {
        this.num = left;
        this.difc = right;
    }
}

class Foo {
    private final long[] p = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47};

    private long answer;
    private long cntForAnswer;
    private long N;

    Foo() {
    }

    public Pair getMaxDifc(long number) {
        N = number;
        answer = 0;
        cntForAnswer = 0;
        findMax(0, 64, 1, 1);
        return new Pair(answer, cntForAnswer);
    }

    private void findMax(int index, int lastA, long value, long cntForValue) {
        if (cntForValue > cntForAnswer || (cntForValue == cntForAnswer && value < answer))
        {
            answer = value;
            cntForAnswer = cntForValue;
        }
        if(index == 15) return;
        for(int a = 1; a <= lastA; a++)
        {
            long temp = value * p[index];
            // проверка на переполнение
            if(temp/p[index] != value) return;

            // если получили число больше N
            if(temp > N) break;

            value = temp;
            findMax(index+1, a, value, cntForValue*(a+1));
        }
    }
}

class Stream {
    private final StreamTokenizer in;
    private final PrintWriter out;

    public Stream() {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(System.out);
    }

    public int nextInt() {
        try {
            in.nextToken();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return (int)in.nval;
    }

    public long nextLong() {
        try {
            in.nextToken();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return (long)in.nval;
    }

    public PrintWriter getOut() {
        return out;
    }
}