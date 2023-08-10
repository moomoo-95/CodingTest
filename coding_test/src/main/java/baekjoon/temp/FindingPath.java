package baekjoon.temp;

import java.io.*;
import java.util.StringTokenizer;

/**
 * [Input]
 * Line 1 : 정점의 개수 n
 * Line 2 ~ n+1 : 정점 간 간선 행렬
 * [Output]
 * Line 2 ~ n+1 : 경로 존재 여부 행렬
 * [Algorithm]
 *
 * [Result]
 * 메모리 : 0 kb
 * 수행시간 : 0 ms
 */
public class FindingPath {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        findingPath();
        stop();
    }

    private static String readInput() {
        try { return reader.readLine(); } catch (Exception e){ return ""; }
    }

    private static void writeOutput(String output) {
        try {
            writer.write(output);
            writer.flush();
        } catch (IOException ignored) {/* ignored */}
    }

    private static void stop(){
        try {
            reader.close();
            writer.close();
        } catch (IOException ignored) {/* ignored */}
    }

    private static void findingPath() {
        int nodeCount = Integer.parseInt(readInput());
        int[][] edgeGraph = new int[nodeCount][nodeCount];
        StringTokenizer st;
        for(int i=0;i<nodeCount;i++){
            st = new StringTokenizer(readInput(), " ");
            for(int j=0;j<nodeCount;j++) edgeGraph[i][j] = Integer.parseInt(st.nextToken());
        }
        int[][] pathGraph = getPathGraph(edgeGraph);
        StringBuilder sb = new StringBuilder();
        for(int[] line : pathGraph){
            sb.append(line).append("\n");
        }
        writeOutput(sb.toString());
    }

    private static int[][] getPathGraph(int[][] edgeGraph) {
        return edgeGraph;
    }
}