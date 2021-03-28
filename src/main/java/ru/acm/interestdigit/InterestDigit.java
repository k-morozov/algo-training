package ru.acm.interestdigit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class InterestDigit {
    public static void main(String[] args) {
        Stream stream = new Stream();
        int left = stream.nextInt();
        int right = stream.nextInt();

        Finder finder = new Finder();
        int result = finder.getCountInterestNumbers(left, right);
        stream.getOut().println(result);
        stream.getOut().flush();
    }
}

class Finder {
    private int lastDivNumber = 0;
    private int currentDivCounter = 0;

    public Finder() {
    }

    private boolean isSimple(long number) {
        if (number % 2 == 0 && number != 2) {
            lastDivNumber = 2;
            ++currentDivCounter;
            return false;
        }

        for (int i = 3; i <= Math.sqrt(number); i+=2) {
            if (number % i == 0) {
                lastDivNumber = i;
                ++currentDivCounter;
                return false;
            }
        }

        return true;
    }

    private boolean isCountSimple(long number) {
        currentDivCounter += 2;
        for(int i = lastDivNumber + 1; i<= number / 2; ++i) {
            if (number % i == 0) {
                ++currentDivCounter;
            }
        }
//        System.out.println("number: " + number + ", counter: " + currentDivCounter);
        return isSimple(currentDivCounter);
    }


    public int getCountInterestNumbers(long left, long right) {
        int countResult = 0;

        for (long number = left; number <= right; ++number) {
            currentDivCounter = 0;
            lastDivNumber = 0;

            if (isSimple(number)) {
                ++countResult;
            } else {
                if (!isCountSimple(number)) {
                    ++countResult;
                }
            }


        }

        return countResult;
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

    public PrintWriter getOut() {
        return out;
    }
}