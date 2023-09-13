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
public class Ccw {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        ccw();
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

    private static void ccw() {
        int[][] point = new int[3][2];
        for(int i=0;i<3;i++){
            StringTokenizer st = new StringTokenizer(readInput(), " ");
            point[i][0] = Integer.parseInt(st.nextToken());
            point[i][1] = Integer.parseInt(st.nextToken());
        }

        writeOutput(String.valueOf(getDirection(point)));
    }

    private static int getDirection(int[][] point){

        return 0;
    }

    private static boolean isStraightLine(){
        return true;
    }

    private static boolean isClockwise(){
        return true;
    }

    private static boolean isCounterclockwise(){
        return true;
    }
}