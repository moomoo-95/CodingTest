package baekjoon.temp;

import java.io.*;
import java.util.*;

/**
 * [Algorithm]
 *
 * [Result]
 * 메모리 : 0 kb
 * 수행시간 : 0 ms
 */
public class FindCity {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder SB = new StringBuilder();
    private static Map<Integer, List<Integer>> adjList = new HashMap<>();

    public static void main(String[] args) { findCity(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void findCity() {
        StringTokenizer st = new StringTokenizer(readInput(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        for(int i=1;i<=n;i++){ adjList.put(i, new ArrayList<>()); }
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(readInput(), " ");
            adjList.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }



        if(SB.length()==0) SB.append("-1");
        writeOutput(SB.toString());
    }
}