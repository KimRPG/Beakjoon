import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        class Node{
            Node left;
            int mid;
            Node right;

            Node(int node) {
                mid = node;
            }
            Node(){}
            void add(int node) {
                if (mid < node) {
                    if (right == null) right = new Node(node);
                    else right.add(node);
                }
                else{
                    if (left == null) left = new Node(node);
                    else left.add(node);
                }
            }

            void print() {
                if (left != null) {
                    left.print();
                }
                if (right != null) {
                    right.print();
                }
                sb.append(mid).append("\n");

            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.isEmpty()) return;
        Node node = new Node(Integer.parseInt(line));

        while ((line = br.readLine()) != null && !line.isEmpty()) {
            node.add(Integer.parseInt(line));
        }

        node.print();
        System.out.println(sb);
    }
}
