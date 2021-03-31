package ru.acm.Chess;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Scanner;

public class chess {
    public static void main(String[] args) {
        Stream stream = new Stream();
//        Scanner stream = new Scanner(System.in);
        int size = stream.nextInt();

        Foo foo = new Foo(size);
        foo.init();

        boolean result = foo.check();

        if(result) {
            foo.print(stream);
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }
}

class Pair {
    public final int left;
    public final int right;

    Pair(int left, int right) {
        this.left = left;
        this.right = right;
    }
}

class Foo {
    private int[][] data;
    private final int size;
    private final char[] letters = {'a','b','c','d','e','f','g','h','i','j','k'};
    private int countFlag;
    private ArrayList<Pair> resultPos;
    private int[][] chessboard;
    private final Pair[] direction = {
            new Pair (2,1),
            new Pair (-2,1),
            new Pair (2,-1),
            new Pair (-2,-1),
            new Pair (1,2),
            new Pair (-1,2),
            new Pair (1,-2),
            new Pair (-1,-2),
    };

    Foo(int size) {
        this.size = size;
        countFlag = size * size;
        data = new int[this.size][this.size];
        resultPos = new ArrayList<>();
        chessboard= new int[size][size];
    }

    public void print(Stream stream) {
        for (Pair pos: resultPos) {
//            System.out.println(leftters[pos.left] + "" + (pos.right+1));
            stream.getOut().println(letters[pos.left] + "" + (pos.right+1));
            stream.getOut().flush();
        }
    }

    public boolean check() {
        return getShift(0, 0);
    }

    public void init() {
        for(int x = 0; x < size; x++) {
            for(int y = 0; y < size; y++) {
                int count=0;
                for(int k = 0; k < direction.length ; k++) {
                    int x1 = x + direction[k].left;
                    int y1 = y + direction[k].right;

                    if(x1>=0 && x1<size && y1>=0 && y1<size) {
                        count++;
                    }
                }
                chessboard[x][y] = count;
            }
        }

//        System.out.println("===");
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                System.out.print(chessboard[i][j] + " ");
//            }
//            System.out.println("");
//        }
//        System.out.println("===");
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

        boolean result = checkAllSide(x,y);
        if (result) {
            return true;
        }

        ++countFlag;
        data[x][y] = 0;

        resultPos.remove(resultPos.size() - 1);

        return false;

    }

    private boolean checkAllSide(int x, int y) {
        boolean result;

        if (size != 6) {
            int bestId = 100;
            ArrayList<Pair> cases = new ArrayList<Pair>();

            for (int k = 0; k < direction.length; k++) {
                int x1 = x + direction[k].left;
                int y1 = y + direction[k].right;

                if (x1 >= 0 && x1 < size && y1 >= 0 && y1 < size) {
                    if (data[x1][y1] == 0) {
                        if (bestId > chessboard[x1][y1]) {
                            bestId = chessboard[x1][y1];
                            cases.clear();
                            cases.add(new Pair(x1, y1));
                        } else {
                            if (bestId == chessboard[x1][y1]) {
                                cases.add(new Pair(x1, y1));
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < cases.size(); i++) {
                result = getShift(cases.get(i).left, cases.get(i).right);
                if (result) {
                    return true;
                }
            }
        } else {


            // ===============================================
            // up
            result = getShift(x + 1, y + 2);
            if (result) {
                return true;
            }

            result = getShift(x - 1, y + 2);
            if (result) {
                return true;
            }

            // right
            result = getShift(x + 2, y + 1);
            if (result) {
                return true;
            }
            result = getShift(x + 2, y - 1);
            if (result) {
                return true;
            }

            // down
            result = getShift(x + 1, y - 2);
            if (result) {
                return true;
            }
            result = getShift(x - 1, y - 2);
            if (result) {
                return true;
            }

            // left
            result = getShift(x - 2, y + 1);
            if (result) {
                return true;
            }
            result = getShift(x - 2, y - 1);
            if (result) {
                return true;
            }
        }
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