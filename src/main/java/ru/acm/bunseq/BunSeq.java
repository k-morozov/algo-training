package ru.acm.bunseq;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;

public class BunSeq {
    public static void main(String[] args) {
        Stream stream = new Stream();
        int N, K;
        N = stream.nextInt();
        K = stream.nextInt();
        Finder finder = new Finder();
        String result = finder.getSeq(N, K);
        stream.getOut().println(result);
        stream.getOut().flush();
    }
}

class Finder {
    private final int sizeSeq;

    ArrayList<String>[] dp;

    public Finder() {
        sizeSeq = 44;
        dp = new ArrayList[sizeSeq];

        for (int i = 0; i < sizeSeq; i++) {
            dp[i] = new ArrayList<>();

            createSeq(dp[i], i);
        }
    }

    String getSeq(int numSeq, int pos) {
        String seq = new String();

        return seq;
    }

    private void createSeq(ArrayList<String> seqs, int sizeCurrentSeq) {
        StringBuilder currentSeq = new StringBuilder(sizeCurrentSeq);
        currentSeq.append("0".repeat(Math.max(0, sizeCurrentSeq)));

        if (seqs == null) {
            return;
        }

        int currentPos = 0;
        seqs.set(currentPos, currentSeq.toString());
        ++currentPos;

        while(true) {
            StringBuilder newValue = increaseByOne(currentSeq);
            if (!newValue.isEmpty()) {
                seqs.set(currentPos, newValue.toString());
                ++currentPos;
            } else {
                break;
            }
        }

    }

    StringBuilder increaseByOne(StringBuilder seq) {
        return seq;
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
