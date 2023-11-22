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
public class TreeDiameter {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder SB = new StringBuilder();

    public static void main(String[] args) { treeDiameter(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void treeDiameter() {
        int n = Integer.parseInt(readInput());
        int [][] adjMap = new int[n][n];
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(readInput(), " ");
            int node = Integer.parseInt(st.nextToken());
            while (true){
                int target = Integer.parseInt(st.nextToken());
                if(target == -1) break;
                int dist = Integer.parseInt(st.nextToken());
                adjMap[node-1][target-1] = dist;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j || adjMap[i][j] != 0) continue;
                adjMap[i][j] = 10000;
            }
        }
        floydWarshall(adjMap);
        int r = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(r < adjMap[i][j]) r = adjMap[i][j];
            }
        }
        writeOutput(String.valueOf(r));
    }

    private static void floydWarshall(int[][] adjMap) {
        for(int i = 0; i < adjMap.length; i++){
            for(int j = 0; j < adjMap.length; j++) {
                if( adjMap[i][j] > 0){
                    for(int k = 0; k < adjMap.length; k++) {
                        if(adjMap[k][i] > 0) {
                            if(adjMap[k][j] == 0 || adjMap[k][j] > adjMap[k][i] + adjMap[i][j])
                                adjMap[k][j] = adjMap[k][i] + adjMap[i][j];
                        }
                    }
                }
            }
        }
    }
}