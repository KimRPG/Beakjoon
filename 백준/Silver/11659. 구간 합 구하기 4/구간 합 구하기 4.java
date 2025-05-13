class Main {

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int N = read();
        int M = read();
        int[] prefix = new int[N+1];
        for (int i = 0; i < N; i++) {
            prefix[i + 1] = prefix[i] + read();
        }
        for (int i = 0; i < M; i++) {
            int start = read();
            int end = read();
            sb.append(prefix[end] - prefix[start-1]).append("\n");
        }
        System.out.println(sb);

    }
    private static int read() throws Exception {

        int c, n = System.in.read() & 15;

        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);

        return n;

    }

}