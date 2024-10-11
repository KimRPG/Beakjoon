package silver.p2217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    static int Macro(String str) {
        return Integer.parseInt(str);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        int max = 0;
        int N = Macro(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Macro(br.readLine()));
        }
        list.sort(Comparator.reverseOrder());
//        int max = Collections.max(
//                IntStream.range(0, list.size())
//                        .map(i -> list.get(i) * (i + 1))
//                        .boxed()
//                        .collect(Collectors.toList())
//        );

        for (int i = 0; i < list.size(); i++) {
            if (max < list.get(i) * (i + 1)) {
                //max = list.get(i) * (i + 1);
                max = Math.max(max, list.get(i) * (i + 1));
            }
        }
        System.out.println(max);

    }
}
