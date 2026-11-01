// https://leetcode.com/problems/twisted-mirror-path-count/?envType=daily-question&envId=2026-10-31
class Solution {
    public int uniquePaths(int[][] grid) {
        final int mod = (int) 1e9 + 7;
        int m = grid.length, n = grid[0].length;
        long[][] dp = new long[n][2];
        // dp[c][0] is amount going down, dp[c][1] is amount going right
        dp[0][0] = dp[0][1] = 1;
        for(int r=0; r<m; r++) {
            for(int c=0; c<n; c++) {
                if(r == 0 && c == 0) continue;
                if(grid[r][c] == 0) {
                    long val = 0;
                    val += dp[c][0] % mod;
                    if(c > 0) val += dp[c-1][1] % mod;
                    val %= mod;
                    dp[c][0] = dp[c][1] = val;
                }
                else {
                    dp[c][1] = dp[c][0] % mod;
                    if(c > 0) dp[c][0] = dp[c-1][1] % mod;
                    else dp[c][0] = 0;
                }
            }
        }
        return (int)dp[n-1][0];
    }
}
