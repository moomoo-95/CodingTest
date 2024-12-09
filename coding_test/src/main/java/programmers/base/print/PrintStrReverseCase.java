package programmers.base.print;

import java.io.*;

public class PrintStrReverseCase {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        printStrReverseCase();
        stop();
    }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void printStrReverseCase() {
        char[] input = readInput().toCharArray();
        for(int idx=0;idx<input.length;idx++){
            if(input[idx] < 95){
                input[idx] += 32;
            } else {
                input[idx] -= 32;
            }
        }
        writeOutput(String.valueOf(input));
    }

}