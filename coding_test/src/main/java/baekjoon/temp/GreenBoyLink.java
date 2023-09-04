package baekjoon.temp;

import java.io.*;
import java.util.StringTokenizer;

/**
 * [Input]
 * Line 1 :
 * [Output]
 * Line 1 :
 * [Algorithm]
 *
 * [Result]
 * 메모리 : 0 kb
 * 수행시간 : 0 ms
 */
public class GreenBoyLink {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        greenBoyLink();
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

    private static void greenBoyLink() {
        StringTokenizer st = new StringTokenizer(readInput(), " ");
        int n = Integer.parseInt(st.nextToken());
        while (n != 0){
            int[][] cave = new int[n][n];
            for(int i=0;i<n;i++){
                st = new StringTokenizer(readInput(), " ");
                for(int j=0;j<n;j++){
                    cave[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            SB.append("Problem ").append(n).append(": ").append(findCheapestWay(cave));
            st = new StringTokenizer(readInput(), " ");
            n = Integer.parseInt(st.nextToken());
        }
        writeOutput(SB.toString());
    }

    private static int findCheapestWay(int[][] cave){
        int result = cave[0][0];
        return result;
    }
}