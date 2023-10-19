package baekjoon.temp;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * [Algorithm]
 *
 * [Result]
 * 메모리 : 0 kb
 * 수행시간 : 0 ms
 */
public class YearProgressBar {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final Map<String, Double> months = new HashMap<>();

    static {
        months.put("January", 0.0);
        months.put("February", 31.0);
        months.put("March", 59.0);
        months.put("April", 90.0);
        months.put("May", 120.0);
        months.put("June", 151.0);
        months.put("July", 181.0);
        months.put("August", 212.0);
        months.put("September", 243.0);
        months.put("October", 273.0);
        months.put("November", 304.0);
        months.put("December", 334.0);
    }

    public static void main(String[] args) {
        yearProgressBar();
        stop();
    }

    private static String readInput() {
        try { return READER.readLine(); } catch (Exception e){ return ""; }
    }

    private static void writeOutput(String output) {
        try {
            WRITER.write(output);
            WRITER.flush();
        } catch (IOException ignored) {/* ignored */}
    }

    private static void stop(){
        try {
            READER.close();
            WRITER.close();
        } catch (IOException ignored) {/* ignored */}
    }

    private static void yearProgressBar() {
        StringTokenizer st = new StringTokenizer(readInput(), " ");
        double days = months.get(st.nextToken()) + Double.parseDouble(st.nextToken().replace(",", "")) - 1.0;
        int year = Integer.parseInt(st.nextToken());
        double total = 365.0;
        if(year%400==0 || year%4==0&&year%100!=0){
            total+=1.0;
            if(days>=59.0) days+=1.0;
        }
        String[] tmp = st.nextToken().split(":");
        double time = (Double.parseDouble(tmp[0])*60.0+Double.parseDouble(tmp[1]))/1440.0;
        days += time;
        double result = days*100.0/total;
        writeOutput(String.valueOf(result));
    }
}