package baekjoon.temp;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [Algorithm]
 *
 * [Result]
 * 메모리 : 0 kb
 * 수행시간 : 0 ms
 */
public class BabyShark {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static ArrayList<Integer[]> fishes = new ArrayList<>();
    private static ArrayList<Integer[]> edibleFishes = new ArrayList<>();
    private static int n;
    private static int[][] space;
    private static int[] baby;
    private static int exp = 0;
    private static int time = 0;

    public static void main(String[] args) { babyShark(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void babyShark() {
        n = Integer.parseInt(readInput());
        int[][] space = new int[n][n];
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(readInput(), " ");
            for(int j=0;j<n;j++){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == 0){continue;}
                else if(tmp == 9) {baby = new int[]{2, i,j};}
                else {
                    space[i][j] = tmp;
                    if(tmp >= 2) {
                        fishes.add(new Integer[]{tmp, i, j});
                    } else {
                        edibleFishes.add(new Integer[]{tmp, i, j});
                    }
                }
            }
        }
        Integer findFish = findingNearestFish();
        while (findFish != null) {
            eatingFish(findFish);
            findFish = findingNearestFish();
        }
        writeOutput(String.valueOf(time));
    }

    private static void eatingFish(int idx){
        Integer[] fish = edibleFishes.remove(idx);
        baby[1] = fish[1];
        baby[2] = fish[2];
        if(++exp==baby[0]) {
            exp = 0;
            baby[0]++;

            for(int i = 0; i< fishes.size(); i++){
                if(fishes.get(i)[0]<baby[0]){
                    edibleFishes.add(fishes.remove(i));
                }
            }
        }
    }

    private static Integer findingNearestFish(){
        int[][] distance = new int[n][n];
        distance[baby[1]][baby[2]] = 500;
        setDistance(distance, baby[1], baby[2]);
        Integer idx = null;
//        Integer dist = -1;
//        for(int i=0;i<edibleFishes.size();i++){
//            Integer[] f = edibleFishes.get(i);
//            dist = getDistance(baby[1], baby[2], f[1], f[2]);
//        }
        return idx;
    }

    private static void setDistance(int[][] distance, int x, int y){
        if(isMovable(x-1, y)) setDistance(distance, x-1, y);
        if(isMovable(x, y+1)) setDistance(distance, x, y+1);
        if(isMovable(x+1, y)) setDistance(distance, x+1, y);
        if(isMovable(x, y-1)) setDistance(distance, x, y-1);
    }

    private static boolean isMovable(int x, int y){
        if(x<0||x>=n) return false;
        if(y<0||y>=n) return false;
        return space[x][y] <= baby[0];
    }
}