class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int r=0, c=0;
        while(c < n-1) dfs(r, c++, grid);
        while(r < m-1) dfs(r++, c, grid);
        while(c > 0) dfs(r, c--, grid);
        while(r > 0) dfs(r--, c, grid);
        int ans = 0;
        for(r=1; r<m-1; r++) {
            for(c=1; c<n-1; c++) {
                if(grid[r][c] == 0) {
                    ans++;
                    dfs(r, c, grid);
                }
            }
        }
        return ans;
    }

    public void dfs(int r, int c, int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if(r < 0 || r == m || c < 0 || c == n || grid[r][c] == 1) return;
        grid[r][c] = 1;
        dfs(r-1, c, grid);
        dfs(r, c+1, grid);
        dfs(r+1, c, grid);
        dfs(r, c-1, grid);
    }
}
