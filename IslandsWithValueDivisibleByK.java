// https://leetcode.com/problems/count-islands-with-total-value-divisible-by-k/description/?envType=daily-question&envId=2026-10-26
class Solution {
    public int countIslands(int[][] grid, int k) {
        int ans = 0;
        int m = grid.length, n = grid[0].length;
        for(int r=0; r<m; r++) {
            for(int c=0; c<n; c++) {
                if(grid[r][c] > 0) {
                    long res = dfs(grid, r, c);
                    if(res % k == 0) ans++;
                }
            }
        }
        return ans;
    }

    public long dfs(int[][] grid, int r, int c) {
        int m = grid.length, n = grid[0].length;
        if(r < 0 || r == m || c < 0 || c == n || grid[r][c] == 0) return 0;
        long total = grid[r][c];
        grid[r][c] = 0;
        int[][] dirs = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int[] dir : dirs) {
            total += dfs(grid, r+dir[0], c+dir[1]);
        }
        return total;
    }
}
