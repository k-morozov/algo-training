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
        stream.getOut().println("Ready");
        stream.getOut().flush();

        int result = finder.getCountInterestNumbers(left, right);
        stream.getOut().println(result);
        stream.getOut().flush();
    }
}

class GFG {

    // Utility function to do modular
    // exponentiation. It returns (x^y) % p
    static long power(long x, long y, long p) {

        long res = 1; // Initialize result

        //Update x if it is more than or
        // equal to p
        x = x % p;

        while (y > 0) {

            // If y is odd, multiply x with result
            if ((y & 1) == 1)
                res = (res * x) % p;

            // y must be even now
            y = y >> 1; // y = y/2
            x = (x * x) % p;
        }

        return res;
    }

    // This function is called for all k trials.
    // It returns false if n is composite and
    // returns false if n is probably prime.
    // d is an odd number such that d*2<sup>r</sup>
    // = n-1 for some r >= 1
    static boolean miillerTest(long d, long n) {

        // Pick a random number in [2..n-2]
        // Corner cases make sure that n > 4
        int a = 2 + (int)(Math.random() % (n - 4));

        // Compute a^d % n
        long x = power(a, d, n);

        if (x == 1 || x == n - 1)
            return true;

        // Keep squaring x while one of the
        // following doesn't happen
        // (i) d does not reach n-1
        // (ii) (x^2) % n is not 1
        // (iii) (x^2) % n is not n-1
        while (d != n - 1) {
            x = (x * x) % n;
            d *= 2;

            if (x == 1)
                return false;
            if (x == n - 1)
                return true;
        }

        // Return composite
        return false;
    }

    // It returns false if n is composite
    // and returns true if n is probably
    // prime. k is an input parameter that
    // determines accuracy level. Higher
    // value of k indicates more accuracy.
    static boolean isPrime(long n, int k) {

        // Corner cases
        if (n <= 1 || n == 4)
            return false;
        if (n <= 3)
            return true;

        // Find r such that n = 2^d * r + 1
        // for some r >= 1
        long d = n - 1;

        while (d % 2 == 0)
            d /= 2;

        // Iterate given nber of 'k' times
        for (int i = 0; i < k; i++)
            if (!miillerTest(d, n))
                return false;

        return true;
    }

    // Driver program
    public static void main(String args[]) {

        int k = 4; // Number of iterations

        System.out.println("All primes smaller "
                + "than 100: ");

        for (int n = 1; n < 100; n++)
            if (isPrime(n, k))
                System.out.print(n + " ");
    }
}


class Finder {
    private int lastDivNumber = 0;
    private int currentDivCounter = 0;

    public Finder() {
        int count = 0;
        for (long i = 0; i < 1_000_000_000l; i++) {
            if (GFG.isPrime(i, 4)) {
                System.out.println(i);
                count++;
            }
        }
        System.out.println("GFG = " + count);

        count = 0;
        for (long i = 0; i < 1_000_000_000l; i++) {
            if (isSimple(i)) {
                count++;
            }
        }
        System.out.println("My = " + count);
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

// 4 + x1 = x2
// x1 + x2 = 5

// x1 = x2 - 4
// x2 - 4 + x2 = 5
// 2*x2 = 9