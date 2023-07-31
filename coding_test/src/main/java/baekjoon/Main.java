package baekjoon;

import java.io.*;
import java.util.Arrays;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        // 제출할 메서드 추가
        char[][] stars = new char[][] {
                {'*', '*', '*'},
                {'*', ' ', '*'},
                {'*', '*', '*'}
        };

        char[][] result = new char[9][9];

        char[][] lineA = new char[3][9];
        for (int idx =0; idx<stars.length; idx++){
            System.arraycopy(stars[idx], 0, lineA[idx], 0, stars[idx].length);
            System.arraycopy(stars[idx], 0, lineA[idx], stars[idx].length, stars[idx].length);
            System.arraycopy(stars[idx], 0, lineA[idx], stars[idx].length*2, stars[idx].length);
        }

        System.arraycopy(stars, 0, result, 0, stars.length);
        System.arraycopy(stars, 0, result, stars.length, stars.length);
        stop();
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

    private static void stop(){
        try {
            reader.close();
            writer.close();
        } catch (IOException ignored) {/* ignored */}
    }
}
