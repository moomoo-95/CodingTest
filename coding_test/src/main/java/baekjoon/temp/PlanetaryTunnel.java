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
    private static Map<Tunnel, Integer> tMap = new HashMap();
    private static Map<Integer, Set<Integer>> pSets = new HashMap();
    private static int cost = 0;


    public static void main(String[] args) { planetaryTunnel(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void planetaryTunnel() {
        parsingInput();

        // 제일 싼 터널 추출 및 비용 추가
        while (pSets.size()!=1){
            Tunnel minT = tMap.keySet().stream().min((Comparator.comparingInt(o -> tMap.get(o)))).get();
            Integer dist = tMap.remove(minT);
            cost+=dist;
            // 두 행성 Set K,V 추출 및 두 행성 Set 합침
            Integer aK = null, bK = null;
            Set<Integer> aS = null, bS = null;
            for(Map.Entry<Integer, Set<Integer>> e:pSets.entrySet()){
                if(e.getValue().contains(minT.x)) { aK = e.getKey();aS = e.getValue(); }
                if(e.getValue().contains(minT.y)) { bK = e.getKey();bS = e.getValue(); }
                if(aK!=null&&bK!=null) {
                    pSets.remove(bK);
                    aS.addAll(bS);
                    break;
                }
            }
            // 행성 Set 과 또다른 행성 Set 간 중복된 간선 존재 시 싼 간선 이외 제거
            Set<Tunnel> keys = new HashSet<>(tMap.keySet());
            for (Tunnel k:keys){
                if(k.x==bK) {
                    Integer nCost = tMap.remove(k);
                    k.x = aK;
                    if(k.x>k.y){int tmp = k.x;k.x=k.y;k.y=tmp;}
                    if(tMap.containsKey(k)&& tMap.get(k)>nCost) tMap.replace(k, nCost);
                } else if(k.y==bK) {
                    Integer nCost = tMap.remove(k);
                    k.y = aK;
                    if(k.x>k.y){int tmp = k.x;k.x=k.y;k.y=tmp;}
                    if(tMap.containsKey(k)&& tMap.get(k)>nCost) {
                        tMap.replace(k, nCost);
                    }
                }
            }
        }
        writeOutput(String.valueOf(cost));
    }

    private static void parsingInput(){
        int n = Integer.parseInt(readInput());
        Integer[][] pArray = new Integer[n][3];

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
                Tunnel t = new Tunnel(i,j);
                tMap.put(t, Math.min(Math.min(Math.abs(pArray[i][0]-pArray[j][0]), Math.abs(pArray[i][1]-pArray[j][1])), Math.abs(pArray[i][2]-pArray[j][2])));
            }
        }
    }

    static class Tunnel{
        int x, y;
        Tunnel(int x, int y){this.x=x;this.y=y;}
        @Override
        public boolean equals(Object o) {
            Tunnel po = (Tunnel) o;
            return this.x == po.x && this.y == po.y;
        }
        @Override
        public int hashCode() {
            return Objects.hashCode(x*100000+y);
        }
    }
}