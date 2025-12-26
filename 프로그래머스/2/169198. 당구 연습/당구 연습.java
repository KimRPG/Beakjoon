class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];

        for (int i = 0; i < balls.length; i++) {
            int targetX = balls[i][0];
            int targetY = balls[i][1];
            
            int minDistanceSq = Integer.MAX_VALUE;

            if (!(startY == targetY && startX > targetX)) {
                minDistanceSq = Math.min(minDistanceSq, calcDistance(startX, startY, -targetX, targetY));
            }

            if (!(startY == targetY && startX < targetX)) {
                minDistanceSq = Math.min(minDistanceSq, calcDistance(startX, startY, 2 * m - targetX, targetY));
            }

            if (!(startX == targetX && startY < targetY)) {
                minDistanceSq = Math.min(minDistanceSq, calcDistance(startX, startY, targetX, 2 * n - targetY));
            }

            if (!(startX == targetX && startY > targetY)) {
                minDistanceSq = Math.min(minDistanceSq, calcDistance(startX, startY, targetX, -targetY));
            }

            answer[i] = minDistanceSq;
        }

        return answer;
    }

    private int calcDistance(int x1, int y1, int x2, int y2) {
        return (int) (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}