import java.util.*;

class Solution {
    int n;
    int[] val;
    long[] cumLen, cumSum;
    long N;

    public long[] solution(int[] arr, long l, long r) {
        n = arr.length;
        val = new int[n];
        cumLen = new long[n];
        cumSum = new long[n];
        long cl = 0, cs = 0;
        for (int k = 0; k < n; k++) {
            val[k] = arr[k];
            cl += arr[k];
            cs += (long) arr[k] * arr[k];
            cumLen[k] = cl;
            cumSum[k] = cs;
        }
        N = cl;

        long W = r - l + 1;
        long K = prefixSum(r) - prefixSum(l - 1); // brr[l-1 .. r-1]
        long C = countWindows(W, K);
        return new long[]{K, C};
    }

    private long prefixSum(long m) {          // B[0..m-1] 의 합
        if (m <= 0) return 0;
        if (m > N) m = N;
        int run = lowerBoundLen(m);
        long beforeLen = run == 0 ? 0 : cumLen[run - 1];
        long beforeSum = run == 0 ? 0 : cumSum[run - 1];
        return beforeSum + (m - beforeLen) * (long) val[run];
    }

    private int lowerBoundLen(long target) {  // cumLen[k] >= target 인 가장 작은 k
        int lo = 0, hi = n - 1, ans = n - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (cumLen[mid] >= target) { ans = mid; hi = mid - 1; }
            else lo = mid + 1;
        }
        return ans;
    }

    private long B(long idx) { return val[lowerBoundLen(idx + 1)]; } // 가상 배열 값
    private long windowSum(long s, long W) { return prefixSum(s + W) - prefixSum(s); }

    private long countWindows(long W, long K) {
        long lastS = N - W;                   // 윈도우 시작 s: 0 .. lastS
        if (lastS < 0) return 0;

        // 변화량이 바뀌는 s 지점만 모은다
        TreeSet<Long> pts = new TreeSet<>();
        pts.add(0L);
        for (int k = 0; k < n; k++) {
            long a = cumLen[k];               // B[s] 가 바뀌는 s
            long b = cumLen[k] - W;           // B[s+W] 가 바뀌는 s (마지막 항이 lastS 보장)
            if (a >= 0 && a <= lastS) pts.add(a);
            if (b >= 0 && b <= lastS) pts.add(b);
        }

        Long[] p = pts.toArray(new Long[0]);
        long count = 0;
        for (int i = 0; i < p.length; i++) {
            long segStart = p[i];
            long segEnd = (i + 1 < p.length) ? p[i + 1] - 1 : lastS;
            if (segEnd < segStart) continue;
            long len = segEnd - segStart + 1;
            long base = windowSum(segStart, W); // 이 구간 첫 윈도우 합

            if (len == 1) {                     // B[s+W] 범위 밖 접근 방지용 처리
                if (base == K) count++;
                continue;
            }
            long step = B(segStart + W) - B(segStart); // 구간 내 일정
            if (step == 0) {
                if (base == K) count += len;            // 전부 K 거나 전부 아님
            } else {
                long diff = K - base;                   // base + step*t = K
                if (diff % step == 0) {
                    long t = diff / step;
                    if (t >= 0 && t <= len - 1) count++;
                }
            }
        }
        return count;
    }
}