// https://leetcode.com/problems/score-of-parentheses/?envType=daily-question&envId=2026-10-05
class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') stack.push(-1);
            else {
                if(stack.peek() == -1) {
                    stack.pop();
                    stack.push(1);
                }
                else {
                    int num = 0;
                    while(stack.peek() != -1) {
                        num += 2 * stack.pop();
                    }
                    stack.pop();
                    stack.push(num);
                }
            }
        }
        int ans = 0;
        while(!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
