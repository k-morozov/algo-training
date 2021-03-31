package ru.acm.Chess;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Scanner;

public class chess {
    public static void main(String[] args) {
//        Stream stream = new Stream();
        Scanner stream = new Scanner(System.in);
        int size = stream.nextInt();

        Foo foo = new Foo(size);

        boolean result = foo.check();

        if(result) {
//            System.out.println("POSSIBLE");
            foo.print();
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }
}

class Pair {
    public final int let;
    public final int dig;

    Pair(int left, int right) {
        this.let = left;
        this.dig = right;
    }
}

class Foo {
    private int[][] data;
    private int size;
    private char[] letters = {'a','b','c','d','e','f','g','h','i','j','k'};
    private int countFlag;
    private ArrayList<Pair> resultPos;

    Foo(int size) {
        this.size = size;
        countFlag = size * size;
        data = new int[this.size][this.size];
        resultPos = new ArrayList<>();
    }

    public void print() {
        for (Pair pos: resultPos) {
            System.out.println(letters[pos.let] + "" + (pos.dig+1));
        }
    }

    public boolean check() {
        boolean result = getShift(0, 0);
        return result;
    }

    private boolean getShift(int x, int y) {
        if (x < 0 || x >= size) {
            return false;
        }
        if (y < 0 || y >= size) {
            return false;
        }
        if (data[x][y] == 1) {
            return false;
        }

        --countFlag;
        data[x][y] = 1;
        resultPos.add(new Pair(x, y));

        if (countFlag == 0) {
            return true;
        }

        boolean result;

        // up
        result = getShift(x+1, y+2);
        if (result) {
            return true;
        }

        result = getShift(x-1, y+2);
        if (result) {
            return true;
        }

        // right
        result = getShift(x+2, y+1);
        if (result) {
            return true;
        }
        result = getShift(x+2, y-1);
        if (result) {
            return true;
        }

        // down
        result = getShift(x+1, y-2);
        if (result) {
            return true;
        }
        result = getShift(x-1, y-2);
        if (result) {
            return true;
        }

        // left
        result = getShift(x-2, y+1);
        if (result) {
            return true;
        }
        result = getShift(x-2, y-1);
        if (result) {
            return true;
        }

        ++countFlag;
        data[x][y] = 0;

        resultPos.remove(resultPos.size() - 1);

        return false;

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