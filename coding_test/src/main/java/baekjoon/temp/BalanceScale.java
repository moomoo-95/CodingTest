package baekjoon.temp;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [Algorithm]
 *
 * [Result]
 * 메모리 : 0 kb
 * 수행시간 : 0 ms
 */
public class BalanceScale {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder SB = new StringBuilder();
    private static int n, m;
    private static int[] arr; // 원소를 저장할 배열

    public static void main(String[] args) { balanceScale(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void balanceScale() {
        n = Integer.parseInt(readInput());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(readInput(), " ");
        for (int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        combination(1, 0);
        writeOutput(SB.toString());
    }

    private static void combination(int cnt, int start) {
        if (cnt == m) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        for (int i = start; i <= n; i++) {
            arr[cnt] = i;
            combination(cnt + 1, i + 1); // 오름차순으로 구하면 중복 체크하지 않아도 됨
        }
    }
}