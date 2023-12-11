package baekjoon.temp;

import java.io.*;

/**
 * [Algorithm]
 *
 * [Result]
 * 메모리 : 0 kb
 * 수행시간 : 0 ms
 */
public class PipeTransfer1 {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static char[][] home;
    private static Pipe pipe = new Pipe();

    public static void main(String[] args) { pipeTransfer1(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void pipeTransfer1() {
        int n = Integer.parseInt(readInput());
        home = new char[n][n];
        for(int i=0;i<n;i++){
            home[i] = readInput().replace(" ", "").toCharArray();
        }
        int r = 0;
        writeOutput(String.valueOf(r));
    }

    private static class Pipe{
        int[] lp, rp;
        Pipe(){lp = new int[]{0, 0}; rp = new int[]{0,1};}

        private int getShape(){
            // 가로 : 1 / 세로 : -1/ 대각선 : 0;
            return lp[0]-rp[0]+rp[1]-lp[1];
        }
    }
}