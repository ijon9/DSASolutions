// https://leetcode.com/problems/most-beautiful-item-for-each-query/
class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int ans = 0;
        for(int r=0; r<m; r++) {
            for(int c=0; c<n; c++) {
                if(matrix[r][c] == 1 && r > 0 && c > 0) {
                    matrix[r][c] = 1 + Math.min(matrix[r-1][c-1], Math.min(matrix[r-1][c], matrix[r][c-1]));
                }
                ans += matrix[r][c];
            }
        }
        return ans;
    }
}
