package baekjoon.temp;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * [Algorithm]
 * 수학
 * 정수론
 * 소수 판정
 * 에라토스테네스의 체
 * [Result]
 * 메모리 : 0 kb
 * 수행시간 : 0 ms
 */
public class GoldbachConjecture {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder SB = new StringBuilder();
    private static final Set<Integer> primes = new HashSet<>();

    public static void main(String[] args) { goldbachConjecture(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void goldbachConjecture() {
        int t = Integer.parseInt(readInput());
        for(int i=0;i<t;i++){
            int n = Integer.parseInt(readInput());
            setPrime(n);
            List<Integer> list = primes.stream().filter(p->(n/2)>=p).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
            for(int j=0;j<list.size();j++){
                int p = list.get(j);
                if(primes.contains(p)&&primes.contains(n-p)) {
                    SB.append(p).append(" ").append(n-p).append("\n");
                    break;
                }
            }
        }
        writeOutput(SB.toString());
    }

    private static void setPrime(int n){
        for(int i=n ; i>1 ; i--){
            if(isPrime(i)){
                if(primes.contains(i)) return;
                primes.add(i);
            }
        }
    }

    private static boolean isPrime(int n){
        for(int i=2 ; i<=(int)Math.sqrt(n) ; i++){
            if(n%i==0) return false;
        }
        return true;
    }
}