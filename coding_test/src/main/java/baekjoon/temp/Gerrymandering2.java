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
public class Gerrymandering2 {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int n;
    private static int [][] district;
    private static int result = 100;

    public static void main(String[] args) {
        gerrymandering2();
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

    private static void gerrymandering2() {
        n = Integer.parseInt(readInput());
        district = new int[n][n];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(readInput(), " ");
            for(int j=0;j<n;j++){
                district[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int x=0;x<n;x++){
            for(int y=0;y<n;y++){
//                for(int d1=0;d1<Math.min(n-x, y);d1++){
//                    for(int d2=0;d2<Math.min(n-x, y);d2++){
//
//                    }
//                }
            }
        }
        writeOutput(String.valueOf(result));
    }

    private static int diffInPopulation(int x, int y, int d1, int d2){

        return 0;
    }
}