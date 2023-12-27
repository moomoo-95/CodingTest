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
public class PalindromeDivision {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) { palindromeDivision(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void palindromeDivision() {
        List<List<Character>> pList = new ArrayList<>();
        char[] input = readInput().toCharArray();
        pList.add(new ArrayList<>());
        pList.get(0).add(input[0]);
        for(int i=1;i<input.length;i++){
            List<Character> fnList = pList.get(pList.size()-1);
            List<Character> snList = null;
            if(pList.size()>1){
                snList = pList.get(pList.size()-2);
            }
            if(isPalindrome(fnList, List.of(input[i]))) {
                fnList.add(input[i]);
            } else if(pList.size()>1&& isPalindrome(snList, fnList, List.of(input[i]))) {
                snList.addAll(pList.remove(pList.size()-1));
                snList.add(input[i]);
                fnList = snList;
            } else if(pList.size()>1&& isPalindrome(snList.subList(snList.size()-2, snList.size()-1), fnList, List.of(input[i]))){
//                snList.re(snList.size()-1);

            } else {
                pList.add(new ArrayList<>());
                pList.get(pList.size()-1).add(input[i]);
                continue;
            }
            for(int j=pList.size()-2;j>=0;j--){
                if(isPalindrome(pList.get(j), fnList)){
                    pList.get(j).addAll(fnList);
                    pList.remove(pList.size()-1);
                    fnList = pList.get(j);
                } else {
                    break;
                }
            }
        }
        writeOutput(String.valueOf(pList.size()));
    }

    private static boolean isPalindrome(List<Character>... lists){
        List<Character> list = new ArrayList<>();
        for(List<Character> l:lists){
            list.addAll(l);
        }
        boolean isP = true;
        for(int i=0;i<list.size()/2;i++){
            if(list.get(i)!=list.get(list.size()-1-i)){
                isP = false;
                break;
            }
        }
        return isP;
    }
}