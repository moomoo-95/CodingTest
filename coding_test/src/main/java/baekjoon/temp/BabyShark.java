package baekjoon.temp;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * [Algorithm]
 *
 * [Result]
 * 메모리 : 0 kb
 * 수행시간 : 0 ms
 */
public class BabyShark {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder SB = new StringBuilder();
    private static int[][] space;
    private static int[] baby;
    private static ArrayList<Integer[]> fishes = new ArrayList<>();

    public static void main(String[] args) { babyShark(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void babyShark() {
        int n = Integer.parseInt(readInput());
        int[][] space = new int[n][n];
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(readInput(), " ");
            for(int j=0;j<n;j++){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == 0){continue;}
                else if(space[i][j] == 9) {baby = new int[]{2, i,j};}
                else {space[i][j] = tmp; fishes.add(new Integer[]{tmp, i, j});}
            }
        }

        writeOutput(SB.toString());
    }
}