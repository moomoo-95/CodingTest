package baekjoon.temp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * [Algorithm]
 *
 * [Result]
 * 결과 1
 * 메모리 : 0 kb
 * 수행시간 : 0 ms
 */
public class Bishop {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[][] chessboard;
    private static List<Integer[]> bishopPoint = new ArrayList<>();
    private static int N;
    private static int r = 0;

    public static void main(String[] args) {bishop();stop();}

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void bishop() {
        N = Integer.parseInt(readInput());
        chessboard = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i< N; i++){
            st = new StringTokenizer(readInput(), " ");
            for (int j = 0; j< N; j++){
                if(st.nextToken().equals("1")) chessboard[i][j] = 1;
            }
        }

        for (int i = 0; i< N; i++){
            for (int j = 0; j< N; j++){
                if(isAvailablePoint(i,j)) bishopPoint.add(new Integer[]{i,j});
            }
        }

        writeOutput(String.valueOf(r));
    }

    public static void putDownBishop(int x, int y){
        for (int i = x; i< N; i++){
            for (int j = y+1; j< N; j++){
                if(isAvailablePoint(i,j)) bishopPoint.add(new Integer[]{i,j});
            }
        }
    }

    private static boolean isAvailablePoint(int x, int y){
        if(chessboard[x][y] == 1) return false;
        for (Integer[] b:bishopPoint){
            if(Math.abs(b[0]-x)==Math.abs(b[1]-y)) return false;
        }
        return true;
    }
}