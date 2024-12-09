package programmers.base.print;
import java.io.*;
public class PrintAB {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        printAB();
        stop();
    }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void printAB() {
        String[] input = readInput().split(" ");
        StringBuilder sb = new StringBuilder();
        sb.append("a = ").append(input[0]).append("\nb = ").append(input[1]);
        writeOutput(sb.toString());
    }
}