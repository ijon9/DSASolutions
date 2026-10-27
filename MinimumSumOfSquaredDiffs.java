// https://leetcode.com/problems/minimum-sum-of-squared-difference/description/?envType=daily-question&envId=2026-10-10
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long[] diffs = new long[n];
        for(int i=0; i<n; i++) diffs[i] = (long)Math.abs(nums1[i]-nums2[i]);
        Arrays.sort(diffs);
        int count = 1;
        long val = diffs[n-1];
        int mods = k1 + k2;
        long ans = 0;
        boolean limitReached = false;
        for(int i=n-2; i>=0; i--) {
            if((val - diffs[i]) * count <= mods) {
                mods -= (val - diffs[i]) * count;
                val = diffs[i];
                count++;
            }
            else if(mods > 0) {
                int reduction = mods / count;
                int remainder = mods % count;
                val -= Math.min(reduction, val);
                ans += (count - remainder) * (val * val);
                ans += remainder * (Math.max(val-1, 0) * Math.max((val - 1), 0));
                ans += diffs[i] * diffs[i];
                limitReached = true;
                mods = 0;
            }
            else if(mods == 0) {
                ans += diffs[i] * diffs[i];
            }
        }
        if(!limitReached) {
            int reduction = mods / count; 
            int remainder = mods % count; 
            val -= Math.min(reduction, val);
            ans += (count - remainder) * (val * val);
            ans += remainder * (Math.max(val-1, 0) * Math.max((val - 1), 0));
            mods = 0;
        }
        return ans;
    }
}
