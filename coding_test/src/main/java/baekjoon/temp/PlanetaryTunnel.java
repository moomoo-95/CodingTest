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
public class PlanetaryTunnel {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static Integer[][] pArray;
    private static Map<Set<Integer>, Integer> tMap = new HashMap();
    private static Map<Integer, Set<Integer>> pSets = new HashMap();
    private static final int cost = 0;


    public static void main(String[] args) { planetaryTunnel(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void planetaryTunnel() {
        int n = Integer.parseInt(readInput());
        pArray = new Integer[n][3];

        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(readInput(), " ");
            pArray[i] = new Integer[]{Integer.valueOf(st.nextToken()),Integer.valueOf(st.nextToken()),Integer.valueOf(st.nextToken())};
            Set<Integer> s = new HashSet<>();
            s.add(i);
            pSets.put(i, s);
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                Set<Integer> t = new HashSet<>();
                t.add(i);t.add(j);
                tMap.put(t, Math.min(Math.min(Math.abs(pArray[i][0]-pArray[j][0]), Math.abs(pArray[i][1]-pArray[j][1])), Math.abs(pArray[i][2]-pArray[j][2])));
            }
        }
        // 메서드화 할 예정(반복)
        Set<Integer> minK = tMap.keySet().stream().min((Comparator.comparingInt(o -> tMap.get(o)))).get();
        Integer[] minT = minK.toArray(new Integer[2]);
        Integer dist = tMap.remove(minK);
        Integer aK = null, bK = null;
        Set<Integer> aS = null, bS = null;
        for(Integer k:pSets.keySet()){
            Set<Integer> s = pSets.get(k);
            if(s.contains(minT[0])) { aK = k;aS = s; }
            if(s.contains(minT[1])) { bK = k;bS = s; }
            if(aK!=null&&bK!=null) {
                aS.addAll(bS);
                pSets.remove(bK);
                break;
            }
        }


        writeOutput(String.valueOf(cost));
    }
}