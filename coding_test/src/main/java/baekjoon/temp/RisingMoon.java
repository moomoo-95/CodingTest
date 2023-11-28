package baekjoon.temp;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [Algorithm]
 *
 * [Result]
 * 메모리 : 0 kb
 * 수행시간 : 0 ms
 */
public class RisingMoon {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder SB = new StringBuilder();
    private static char[][] maze;
    private static boolean[] hasKey = new boolean[6];

    public static void main(String[] args) { risingMoon(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void risingMoon() {
        StringTokenizer st = new StringTokenizer(readInput(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        maze = new char[n][m];
        for(int i=0;i<n;i++){
            maze[i] = Arrays.stream(readInput().split("")).map(s-> s.charAt(0)).toArray());
        }
        writeOutput(SB.toString());
    }
}