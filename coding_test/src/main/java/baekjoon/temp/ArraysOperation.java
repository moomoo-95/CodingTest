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
public class ArraysOperation {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder SB = new StringBuilder();

    public static void main(String[] args) { arrayOperation(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void arrayOperation() {
        StringTokenizer st = new StringTokenizer(readInput(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<List<Integer>> array = new ArrayList<>();
        for(int i=0;i<3;i++){
            st = new StringTokenizer(readInput(), " ");
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(Integer.parseInt(st.nextToken()));
            temp.add(Integer.parseInt(st.nextToken()));
            temp.add(Integer.parseInt(st.nextToken()));
            array.add(temp);
        }

        int result = -1;
        for(int s=0;s<100;s++){
            if ((array.size()>=r&&array.get(0).size()>=c) && array.get(r-1).get(c-1) == k){
                result = s;
                break;
            }

            if(array.size() <= array.get(0).size()){
                calculationR(array);
            } else {
                calculationC(array);
            }
        }
        writeOutput(String.valueOf(result));
    }

    private static void calculationR(List<List<Integer>> array){
        int max = 2;
        for(int i=0;i<array.size();i++){
            List<Integer> oldRow = array.get(i);
            Collections.sort(oldRow);
            List<Integer> newRow = new ArrayList<>();
            int n = -1;
            for(int j=0;j<oldRow.size();j++){
                if(n != oldRow.get(j)){
                    n = oldRow.get(j);
                    newRow.add(n);
                    newRow.add(1);
                } else {
                    newRow.set(newRow.size()-1, newRow.get(newRow.size()-1)+1);
                }
            }
            array.set(i, newRow);
            if(max < newRow.size()) max = newRow.size();
        }
        if(max > 100) max = 100;
        for(int i=0;i<array.size();i++){
            List<Integer> row = array.get(i);
            while (row.size() != max){
                if(row.size() < max){
                    row.add(0);
                } else {
                    row.remove(row.size()-1);
                }
            }
        }
    }

    private static void calculationC(List<List<Integer>> array){

    }
}