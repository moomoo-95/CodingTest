package baekjoon.datastructure.stack;

import java.io.*;

/**
 * [Input]
 * Line 1 :
 * [Output]
 * Line 1 :
 * [Algorithm]
 * 자료 구조
 * 스택
 * [Result]
 * 메모리 : 15788 kb
 * 수행시간 : 160 ms
 */
public class IronRod {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        ironRod();
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

    private static void ironRod() {
        char[] ironRods = readInput().toCharArray();
        writeOutput(getCuttingCount(ironRods));
    }

    private static String getCuttingCount(char[] ironRods) {
        int size = ironRods.length;
        int cnt = 0;
        int rods = 0;
        for(int idx = 0; idx < size; idx++) {
            if(idx < size-1 && ironRods[idx] == '(' && ironRods[idx+1] == ')'){
                cnt += rods;
                idx++;
                continue;
            }
            switch (ironRods[idx]){
                case '(':
                    rods++;
                    break;
                case ')':
                    cnt++;
                    rods--;
                    break;
                default:
            }
        }
        return String.valueOf(cnt);
    }
}