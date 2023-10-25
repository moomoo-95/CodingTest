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
public class LongestBitonicPartialSequence {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder SB = new StringBuilder();

    public static void main(String[] args) { testFormat(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void testFormat() {
        int n = Integer.parseInt(readInput());
        StringTokenizer st = new StringTokenizer(readInput(), " ");
        int s1 = Integer.parseInt(st.nextToken());
        boolean isDec = false;
        int result = 1;
        int size = 1;
        for(int i=1;i<n;i++){
            int s2 = Integer.parseInt(st.nextToken());
            if(s1>s2) isDec = true;

            if(s1<s2 && isDec) {
                isDec = false;
                if(result<size) result = size;
                size = 1;
            } else {
                size++;
            }
            s1 = s2;
        }
        writeOutput(String.valueOf(result));
    }



    private static void longestIncreasingPartialSequence(int[] sequence) {
        int n = sequence.length;
        if(n == 1) {
            writeOutput("1");
            return;
        }
        int[] seqSize = new int[n];
        StringTokenizer st = new StringTokenizer(readInput(), " ");
        for (int i=0;i<n;i++){
            sequence[i] = Integer.parseInt(st.nextToken());
        }
        int result = 0;
        seqSize[n-1] = 1;
        for (int i=n-2;i>=0;i--){
            int addSize = 0;
            for(int j=i+1;j<n;j++){
                if(sequence[i] < sequence[j] && addSize < seqSize[j]) addSize = seqSize[j];
            }
            seqSize[i]=addSize+1;
            if(result < seqSize[i]) result = seqSize[i];
        }
        writeOutput(String.valueOf(result));
    }
}