import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int Macro(String st) {
        return Integer.parseInt(st);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Macro(st.nextToken()); // Number of jewels
        int K = Macro(st.nextToken()); // Number of bags

        List<Jewel> jewels = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Macro(st.nextToken());
            int value = Macro(st.nextToken());
            jewels.add(new Jewel(weight, value));
        }

        List<Integer> bags = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            bags.add(Macro(br.readLine()));
        }

        // Sort jewels by weight (ascending) and bags by capacity (ascending)
        Collections.sort(jewels, Comparator.comparingInt(j -> j.weight));
        Collections.sort(bags);

        PriorityQueue<Integer> availableJewels = new PriorityQueue<>(Collections.reverseOrder());
        long totalValue = 0;
        int jewelIndex = 0;

        for (int bag : bags) {
            // Add all jewels that can fit in the current bag to the max-heap (sorted by value)
            while (jewelIndex < jewels.size() && jewels.get(jewelIndex).weight <= bag) {
                availableJewels.add(jewels.get(jewelIndex).value);
                jewelIndex++;
            }

            // Take the most valuable jewel that fits in this bag
            if (!availableJewels.isEmpty()) {
                totalValue += availableJewels.poll();
            }
        }

        System.out.println(totalValue);
    }

    static class Jewel {
        int weight;
        int value;

        public Jewel(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}
