package baekjoon.temp;

import java.io.*;
import java.util.StringTokenizer;

/**
 * [Algorithm]
 * 다이나믹 프로그래밍
 * 그래프 이론
 * 그래프 탐색
 * 깊이 우선 탐색
 * [Result]
 * 메모리 : 0 kb
 * 수행시간 : 0 ms
 */
public class Downhill {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[][] hill;
    private static int m;
    private static int n;
    private static int result = 0;

    public static void main(String[] args) {
        downhill();
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

    private static void downhill() {
        StringTokenizer st = new StringTokenizer(readInput(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        hill = new int[m][n];
        for (int i=0;i<m;i++){
            st = new StringTokenizer(readInput(), " ");
            for (int j=0;j<n;j++){
                hill[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        findWay(0, 0);
        writeOutput(String.valueOf(result));
    }

    private static void findWay(int x, int y){
        if(x == m-1 && y == n-1) {
            result++;
            return;
        }
        if(x > 0 && hill[x][y] > hill[x-1][y]) findWay(x-1, y);
        if(y > 0 && hill[x][y] > hill[x][y-1]) findWay(x, y-1);
        if(x < m-1 && hill[x][y] > hill[x+1][y]) findWay(x+1, y);
        if(y < n-1 && hill[x][y] > hill[x][y+1]) findWay(x, y+1);
    }
}