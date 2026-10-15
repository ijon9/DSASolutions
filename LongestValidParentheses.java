// https://leetcode.com/problems/longest-valid-parentheses/?envType=daily-question&envId=2026-10-03
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> indices = new Stack<>();
        int n = s.length();
        int ans = 0;
        int[] dp = new int[n];
        for(int i=0; i<n; i++) {
            if(s.charAt(i) == '(') {
                indices.push(i);
            }
            else {
                if(!indices.isEmpty()) {
                    int prev = indices.pop();
                    dp[i] = i - prev + 1 + (prev > 0 ? dp[prev-1] : 0);
                    ans = Math.max(ans, dp[i]);
                }
            }
        }
        return ans;
    }
}
