package ru.acm.SummaDigit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class SummaDigit {
    public static void main(String[] args) {
        Finder finder = new Finder();

        Stream stream = new Stream();

        int countOperations = stream.nextInt();
        int summaSimple, summaSquare;

        for (int i = 0; i < countOperations; i++) {
            summaSimple = stream.nextInt();
            summaSquare = stream.nextInt();
            String result = finder.findNumber(summaSimple, summaSquare);
                stream.getOut().println(result);
                stream.getOut().flush();
        }
    }
}

class Data {
    public Data() {
        value = 0;
        length = 0;
    }
    public int value;
    public int length;
}

class Finder {
    private final int maxSummaSimple = 900;
    private final int maxSummaSquare = 8100;

    private final Data[][] dp;

    public Finder() {
        dp = new Data[maxSummaSimple+9][maxSummaSquare+81];

        for (int i = 1; i < 10; i++) {
            dp[i][i*i] = new Data();
            dp[i][i*i].value = i;
            dp[i][i*i].length = 1;
        }

        for (int i = 1; i < maxSummaSimple; i++) {
            for (int j = 1; j < maxSummaSquare; j++) {
                if (dp[i][j] != null && dp[i][j].value != 0) {
                    for (int k = 1; k < 10; k++) {
                        if (dp[i + k][j + k * k] == null) {
                            dp[i + k][j + k * k] = new Data();

                            dp[i + k][j + k * k].value = k;
                            dp[i + k][j + k * k].length = dp[i][j].length + 1;
                        } else if (dp[i + k][j + k * k].length >= dp[i][j].length + 1) {
                            if (dp[i + k][j + k * k].value >= k) {
                                dp[i + k][j + k * k].value = k;
                            }
                            dp[i + k][j + k * k].length = dp[i][j].length + 1;
                        }
                    }

                }
            }
        }
    }

    public String findNumber(int summaDigit, int summaSquare) {
        if (isValid(summaDigit, summaSquare)) {
            return getNumber(summaDigit, summaSquare);
        }

        return "No solution";
    }

    private boolean isValid(int summaDigit, int summaSquare) {
        if (summaDigit < 0 || summaDigit > maxSummaSimple) {
            return false;
        }

        if (summaSquare < 0 || summaSquare > maxSummaSquare) {
            return false;
        }

        if (dp[summaDigit][summaSquare] == null) {
            return false;
        }

        if (dp[summaDigit][summaSquare].value == 0) {
            return false;
        }

        if (dp[summaDigit][summaSquare].length > 100) {
            return false;
        }

        return true;
    }

    public String getNumber(int summaDigit, int summaSquare) {
        StringBuilder number = new StringBuilder();

        while (summaDigit > 0 && summaSquare > 0) {
            int value = dp[summaDigit][summaSquare].value;
            if (value == 0) {
                break;
            }
            summaDigit -= value;
            summaSquare -= value * value;
            number.append(value);
        }

        return number.toString();
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
