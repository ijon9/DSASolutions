// https://leetcode.com/problems/maximum-width-ramp/
class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Stack<Integer> leftVals = new Stack<>();
        int ans = 0;
        for(int i=0; i<n; i++) {
            if(leftVals.isEmpty() || nums[leftVals.peek()] > nums[i]) 
                leftVals.push(i);
        }
        for(int i=n-1; i>0; i--) { 
            while(!leftVals.isEmpty() && nums[leftVals.peek()] <= nums[i]) {
                int prev = leftVals.pop();
                ans = Math.max(ans, i-prev);
            }
        }
        return ans;
    }
}
