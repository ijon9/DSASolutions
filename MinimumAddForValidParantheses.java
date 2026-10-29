// https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/?envType=daily-question&envId=2026-10-06
class Solution {
    public int minAddToMakeValid(String s) {
        int ans = 0;
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for(int i=0; i<n; i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) ans++;
                else stack.pop();
            }
        }
        ans += stack.size();
        return ans;
    }
}
