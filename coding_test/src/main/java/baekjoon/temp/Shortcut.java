package baekjoon.temp;

import java.io.*;
import java.util.StringTokenizer;

/**
 * [Input]
 * Line 1 : 지름길 개수 N(<=12), 고속도로 길이 D(<=10000)
 * Line 2 ~ N + 1 : 시작 위치, 도착 위치, 지름길의 길이
 * [Output]
 * Line 1 : 세준이가 운전해야할 거리의 최소값
 * [Algorithm]
 *
 * [Result]
 * 메모리 : 0 kb
 * 수행시간 : 0 ms
 */
public class Shortcut {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        testFormat();
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

    private static void testFormat() {
        StringTokenizer st = new StringTokenizer(readInput(), " ");
        writeOutput(SB.toString());
    }
}