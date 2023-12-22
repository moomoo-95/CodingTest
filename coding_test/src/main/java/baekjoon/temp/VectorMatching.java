package baekjoon.temp;

import java.io.*;
import java.util.StringTokenizer;

/**
 * [Algorithm]
 *
 * [Result]
 * 메모리 : 0 kb
 * 수행시간 : 0 ms
 */
public class VectorMatching {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder SB = new StringBuilder();

    public static void main(String[] args) { vectorMatching(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void vectorMatching() {
        int t = Integer.parseInt(readInput());
        StringTokenizer st;
        for(int i=0;i<t;i++){
            int n = Integer.parseInt(readInput());
            int[][] points = new int[n][2];
            for (int j=0;j<n;j++){
                st = new StringTokenizer(readInput(), " ");
                points[j] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            }
        }
        writeOutput(SB.toString());
    }
}