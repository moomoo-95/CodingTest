package programmers.base.print;

import java.io.*;

public class PrintSpecialStr {
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        printSpecialStr();
        stop();
    }

    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void printSpecialStr() {
        writeOutput("!@#$%^&*(\\'\"<>?:;");
    }

}