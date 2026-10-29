// https://leetcode.com/problems/minimum-xor-path-in-a-grid/?envType=daily-question&envId=2026-10-28
class Solution {

    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] currRow = new boolean[n][1024];
        boolean[] next = new boolean[1024];

        currRow[0][grid[0][0]] = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                int value = grid[i][j];
                Arrays.fill(next, false);

                for (int k = 0; k < 1024; k++) {
                    if (currRow[j][k] || (j > 0 && currRow[j - 1][k])) {
                        next[k ^ value] = true;
                    }
                }

                System.arraycopy(next, 0, currRow[j], 0, 1024);
            }
        }

        for (int k = 0; k < 1024; k++) {
            if (currRow[n - 1][k]) {
                return k;
            }
        }

        return -1;
    }
}
