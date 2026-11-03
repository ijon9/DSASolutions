// https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        final int INF = (int) 1e9 + 7;
        int[][] edgeMat = new int[n][n];
        for(int[] row : edgeMat) Arrays.fill(row, INF);
        for(int i=0; i<n; i++) edgeMat[i][i] = 0;
        for(int[] edge : edges) {
            int one = edge[0], two = edge[1], w = edge[2];
            edgeMat[one][two] = edgeMat[two][one] = w;
        }
        for(int i=0; i<n; i++) {
            int[][] next = new int[n][n];
            for(int r=0; r<n; r++) {
                for(int c=0; c<n; c++) {
                    if(r == i || c == i) next[r][c] = edgeMat[r][c];
                    else if(r == c) next[r][c] = 0;
                    else {
                        next[r][c] = Math.min(edgeMat[r][c], edgeMat[r][i] + edgeMat[i][c]);
                    }
                }
            }
            edgeMat = next;
        }
        int ans = 0;
        int minCities = Integer.MAX_VALUE;
        for(int r=0; r<n; r++) {
            int reachableCities = 0;
            for(int c=0; c<n; c++) if(edgeMat[r][c] <= distanceThreshold) reachableCities++;
            if(reachableCities <= minCities) {
                ans = r;
                minCities = reachableCities;
            }
        }
        return ans;
    }
}
