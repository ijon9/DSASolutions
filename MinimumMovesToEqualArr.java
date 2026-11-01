// https://leetcode.com/problems/minimum-moves-to-equal-array-elements/?envType=daily-question&envId=2026-11-01
class Solution {
    // O(nlogn) solution
    public int minMoves(int[] nums) {
        // [1,2,3]
        // Sort array, at least 2 is needed (diff between max and min)
        // [3,4,3]
        // New maximum at the second to last spot. Then, increment all other elements
        // [4,4,4]

        // [1,2,3,4,5,6,7] 6
        // [7,8,9,10,11,12,7] 5
        // [12,13,14,15,16,12,12] 4
        // [16,17,18,19,16,16,16] 3
        // [19,20,21,19,19,19,19] 2
        // [21,22,21,21,21,21,21] 1
        // [22,22,22,22,22,22,22]
        // total: 21

        // [1,2,3,3,3,4,5]
        // [5,6,7,7,7,8,5]
        // [8,9,10,10,10,8,8]
        // [10,11,12,12,10,10,10]
        // [12,13,14,12,12,12,12]
        // [14,15,14,14,14,14,14]
        // [15,15,15,15,15,15,15]
        Arrays.sort(nums);
        int n = nums.length;
        int diff = nums[n-1] - nums[0];
        if(diff == 0) return 0;
        int total = diff;
        for(int i=n-2; i>0; i--) {
            nums[i] += total;
            total += nums[i] - nums[i+1];
        }
        return total;
    }
}

// O(n) solution
class Solution {
    public int minMoves(int[] nums) {
        int min = nums[0];
        for(int num : nums) min = Math.min(min, num);
        int total = 0;
        for(int num : nums) total += num - min;
        return total;
    }
}
