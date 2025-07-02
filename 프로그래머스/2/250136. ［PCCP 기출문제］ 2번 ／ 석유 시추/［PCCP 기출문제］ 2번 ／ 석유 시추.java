import java.util.*;

class Solution {

    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int solution(int[][] land) {
        int answer = 0;

        int[] oils = findOil(land);

        for (int oil : oils) {
            answer = Math.max(answer, oil);
        }

        return answer;
    }

    public int[] findOil(int[][] land) {
        int landRows = land.length;
        int landCols = land[0].length;
        int[] oils = new int[landCols];

        boolean[][] visited = new boolean[landRows][landCols];

        for (int i = 0; i < landRows; i++) {
            for (int j = 0; j < landCols; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    Queue<int[]> taskQue = new LinkedList<>();
                    int minCol = j, maxCol = j, oilCount = 0;

                    taskQue.offer(new int[] {i, j});

                    while (!taskQue.isEmpty()) {
                        int[] loc = taskQue.poll();
                        int row = loc[0];
                        int col = loc[1];

    
                        if (visited[row][col]) continue;
                        visited[row][col] = true;


                        minCol = Math.min(minCol, col);
                        maxCol = Math.max(maxCol, col);
                        oilCount++;

                        for (int[] dir : DIRS) {
                            int nr = row + dir[0];
                            int nc = col + dir[1];

                            if (0 <= nr && nr < landRows &&
                                0 <= nc && nc < landCols &&
                                land[nr][nc] == 1 && !visited[nr][nc]) {
                                taskQue.offer(new int[] {nr, nc});
                            }
                        }
                    }

                    for (int k = minCol; k <= maxCol; k++) {
                        oils[k] += oilCount;
                    }
                }
            }
        }

        return oils;
    }
}

