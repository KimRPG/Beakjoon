import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        int len = str.length;
        int[] DP = new int[len+1];
        int div = 1_000_000;
        DP[1] = DP[0] = 1;
        if(str[0] == '0'){
            DP[len] = 0;
        }else{
            for(int i=2; i<=len;i++){
                int preC = Character.getNumericValue(str[i-2]);
                int curC =  Character.getNumericValue(str[i-1]);
                if(curC == 0){
                    if(preC == 1 || preC == 2){
                        DP[i] = DP[i-2];
                    }
                }else{
                    if(preC == 1 || (preC == 2 && curC <= 6)){
                        DP[i] = (DP[i-1] + DP[i-2]) % div;
                    }else{
                        DP[i] = DP[i-1];
                    }
                }
            }
        }
        System.out.println(DP[len]);

    }
}