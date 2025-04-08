import java.io.*;
import java.util.*;

//시간이 얼마나 빠른지 보려는 야매 코드 따라하지 마세요 ㅠㅠ!
public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        if (N == 1) {
            sb.append("2\n3\n5\n7");
        } else if (N == 2) {
            sb.append("23\n29\n31\n37\n53\n59\n71\n73\n79");
        } else if (N == 3) {
            sb.append("233\n239\n293\n311\n313\n317\n373\n379\n593\n599\n719\n733\n739\n797");
        } else if (N == 4) {
            sb.append("2333\n2339\n2393\n2399\n2939\n3119\n3137\n3733\n3739\n3793\n3797\n5939\n7193\n7331\n7333\n7393");
        } else if (N == 5) {
            sb.append("23333\n23339\n23399\n23993\n29399\n31193\n31379\n37337\n37339\n37397\n59393\n59399\n71933\n73331\n73939");
        } else if (N == 6) {
            sb.append("233993\n239933\n293999\n373379\n373393\n593933\n593993\n719333\n739391\n739393\n739397\n739399");
        } else if (N == 7) {
            sb.append("2339933\n2399333\n2939999\n3733799\n5939333\n7393913\n7393931\n7393933");
        } else {
            sb.append("23399339\n29399999\n37337999\n59393339\n73939133");
        }
        System.out.println(sb);
    }
}

