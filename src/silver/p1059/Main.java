package silver.p1059;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int setLength = Integer.parseInt(br.readLine());
        int result;
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            list.add(Integer.parseInt(st.nextToken()));
        }
        int n = Integer.parseInt(br.readLine());
        list.add(n);
        list.sort(Comparator.naturalOrder());

        int i = list.indexOf(n);
        if(i==0){
            result = (n) * (list.get(i + 1) - n) - 1;
        }
        else if(i==setLength){
            result =(n - list.get(i - 1)) * (1000-n) -1;
        } else result = (n - list.get(i - 1)) * (list.get(i + 1) - n) - 1;
        if( result <0)  result =0;

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
    }
}
