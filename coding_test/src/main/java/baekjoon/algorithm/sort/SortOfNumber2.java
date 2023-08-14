package baekjoon.algorithm.sort;

import java.io.*;
import java.util.HashSet;

/**
 * [Input]
 * Line 1 : 수의 개수 N
 * Line 2 ~ N+1 : 수
 * [Output]
 * Line 1 ~ N : 정렬된 수
 * [Algorithm]
 * 정렬
 * [Result]
 * 메모리 : 202508 kb
 * 수행시간 : 1524 ms
 */
public class SortOfNumber2 {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        sortOfNumber2();
        stop();
    }

    private static String readInput() {
        try { return READER.readLine(); } catch (Exception e){ return ""; }
    }

    private static void writeOutput(String output) {
        try {
            WRITER.write(output);
            WRITER.flush();
        } catch (IOException ignored) {/* ignored */}
    }

    private static void stop(){
        try {
            READER.close();
            WRITER.close();
        } catch (IOException ignored) {/* ignored */}
    }

    private static void sortOfNumber2() {
        int cnt = Integer.parseInt(readInput());
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i=0;i<cnt;i++){
            hashSet.add(Integer.parseInt(readInput()));
        }
        hashSet.stream().sorted().forEach(i -> SB.append(i).append("\n"));
        writeOutput(SB.toString());
    }
}