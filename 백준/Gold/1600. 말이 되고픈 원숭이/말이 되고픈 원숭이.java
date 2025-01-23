import java.io.*;
import java.util.*;

class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[] hx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] hy = {1, -1, 2, -2, 2, -2, 1, -1};
    static int[][] arr;

    static boolean[][][] isVisit;

    static int K, W, H;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[H][W];
        isVisit = new boolean[H][W][K+1];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        isVisit[0][0][K] = true;
        int ans = BFS(0, 0, K, 0);
        System.out.println(ans);
    }

    public static int BFS(int w, int h, int remainK, int result) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(w, h, remainK, result));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int aW = node.w;
            int aH = node.h;
            int aRemainK = node.remainK;
            int aResult = node.result;

            if (aW == W - 1 && aH == H - 1) {
                return aResult;
            }
            int dResult = aResult + 1;

            if (aRemainK > 0) {
                int dRemainK = aRemainK - 1;

                for (int i = 0; i < 8; i++) {
                    int dw = aW + hx[i];
                    int dh = aH + hy[i];
                    if(dw<0 || dw>=W || dh<0 || dh>=H) continue;
                    if (arr[dh][dw] == 1 || isVisit[dh][dw][dRemainK]) continue;
                    queue.add(new Node(dw, dh, dRemainK, dResult));
                    isVisit[dh][dw][dRemainK] = true;
                }
            }
            for (int i = 0; i < 4; i++) {
                int dw = aW + dx[i];
                int dh = aH + dy[i];
                if(dw<0 || dw>=W || dh<0 || dh>=H) continue;
                if (arr[dh][dw] == 1 || isVisit[dh][dw][aRemainK]) continue;
                queue.add(new Node(dw, dh, aRemainK, dResult));
                isVisit[dh][dw][aRemainK] = true;
            }


        }
        return -1;
    }

    public static class Node {

        public Node(int w, int h, int remainK, int result) {
            this.w = w;
            this.h = h;
            this.remainK = remainK;
            this.result = result;
        }

        int w;
        int h;
        int remainK;
        int result;
    }
}
