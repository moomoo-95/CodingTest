package baekjoon.temp;

import java.io.*;
import java.util.*;

/**
 * [Algorithm]
 *
 * [Result]
 * 메모리 : 0 kb
 * 수행시간 : 0 ms
 */
public class Workbook {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        workbook();
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

    private static void workbook() {
        StringTokenizer st = new StringTokenizer(readInput(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> orderWorks = new HashMap<>();
        for (int i=1;i<=n;i++){
            orderWorks.put(i, 0);
        }
        for (int i=0;i<m;i++){
            st = new StringTokenizer(readInput(), " ");
            orderWorks.replace(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        writeOutput(SB.toString());
    }
}