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
public class RisingMoon {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder SB = new StringBuilder();
    private static char[][] maze;
    private static int[] point;
    private static Set<Integer[]>[] doorSet = new HashSet[6];
    private static Set<Integer[]>[] keySet = new HashSet[6];
    private static List<Integer[]> exitList = new ArrayList<>();
    // A 0 / B 1 / C 2 / D 3 / E 4 / F 5

    public static void main(String[] args) { risingMoon(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void risingMoon() {
        StringTokenizer st = new StringTokenizer(readInput(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        setMaze(n,m);
        writeOutput(SB.toString());
    }

    private static void setMaze(int n, int m){
        maze = new char[n][m];
        for(int i=0;i<6;i++){
            doorSet[i] = new HashSet<>();
            keySet[i] = new HashSet<>();
        }
        for(int i=0;i<n;i++){
            maze[i] = readInput().toCharArray();
            for (int j=0;j<m;j++){

                switch (maze[i][j]){
                    case '0':
                        point = new int[] {i, j};
                        break;
                    case '1':
                        exitList.add(new Integer[]{i, j});
                        break;
                    case 'A': case 'B': case 'C': case 'D': case 'E': case 'F':
                        doorSet[maze[i][j]-65].add(new Integer[]{i, j});
                        break;
                    case 'a': case 'b': case 'c': case 'd': case 'e': case 'f':
                        keySet[maze[i][j]-97].add(new Integer[]{i, j});
                        break;
                    default:
                }

            }
        }
    }
}

//7 8
//a#c#eF.1
//.#.#.#..
//.#B#D###
//0....F.1
//C#E#A###
//.#.#.#..
//d#f#bF.1