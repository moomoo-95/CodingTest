package programmers.base.print;

import java.io.*;

public class PrintStrRepeat {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        printStrRepeat();
        stop();
    }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void printStrRepeat() {
        String[] input = readInput().split(" ");
        int cnt = Integer.valueOf(input[1]);
        StringBuilder sb = new StringBuilder();
        for(int idx=0;idx<cnt;idx++){sb.append(input[0]);}
        writeOutput(sb.toString());
    }
}