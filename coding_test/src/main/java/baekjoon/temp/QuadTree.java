package baekjoon.temp;

import java.io.*;

/**
 * [Input]
 * Line 1 :
 * [Output]
 * Line 1 :
 * [Algorithm]
 * 미확인
 * [Result]
 * 메모리 : 0 kb
 * 수행시간 : 0 ms
 */
public class QuadTree {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        quadTree();
    }

    private static String readInput() {
        try { return reader.readLine(); } catch (Exception e){ return ""; }
    }

    private static void writeOutput(String output) {
        try {
            writer.write(output);
            writer.flush();
        } catch (IOException ignored) {/* ignored */}
    }

    private static void quadTree() {
        writeOutput(readInput());
    }
}
