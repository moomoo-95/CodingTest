package baekjoon.temp;

import java.io.*;

/**
 * [Input]
 * Line 1 : 2 * N 타일 길이
 * [Output]
 * Line 1 : 타일 경우의 수 / 1,000,000,007
 * [Algorithm]
 *
 * [Result]
 * 메모리 : 0 kb
 * 수행시간 : 0 ms
 */
public class FillTile3 {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[] numberOfCases;

    public static void main(String[] args) {
        fillTile3();
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

    private static void fillTile3() {
        int length = Integer.valueOf(readInput());
        numberOfCases = new int[length+1];
        numberOfCases[0] = 1;
        numberOfCases[1] = 2;
        numberOfCases[2] = 7;
        writeOutput(String.valueOf(getNumberOfCases(length) % 1000000007));
    }

    private static int getNumberOfCases(int length){
        if(numberOfCases[length] == 0) numberOfCases[length] = getNumberOfCases(length-1)*2 + getNumberOfCases(length-2)*3 + getNumberOfCases(length-3)*2;
        return numberOfCases[length];
    }
}