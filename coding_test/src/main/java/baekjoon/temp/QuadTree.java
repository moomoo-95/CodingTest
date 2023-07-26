package baekjoon.temp;

import java.io.*;

/**
 * [Input]
 * Line 1 : 영상의 크기 n (2의 제곱 수)
 * Line 2~n+1 : 영상을 표현한 n*n 개의 점
 * [Output]
 * Line 1 : 압축 결과
 * [Algorithm]
 * 미확인
 * [Result]
 * 메모리 : 0 kb
 * 수행시간 : 0 ms
 */
public class QuadTree {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        quadTree();
        stop();
    }

    private static String readInput() {
        try { return reader.readLine(); } catch (Exception e){ return ""; }
    }

    private static void writeOutput(String output) {
        try {
            writer.write(output);
            writer.flush();
        } catch (IOException ignored) {/* ignored */}
    }

    private static void stop(){
        try {
            reader.close();
            writer.close();
        } catch (IOException ignored) {/* ignored */}
    }

    private static void quadTree() {
        int splitSize = Integer.parseInt(readInput());
        StringBuilder video = new StringBuilder();
        for(int idx = 0; idx < splitSize; idx++){
            video.append(readInput());
        }

        writeOutput(imageCompression(splitSize, video.toString()));
    }

    private static String imageCompression(int splitSize, String video){

        return video;
    }
}