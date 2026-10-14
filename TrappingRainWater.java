class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int maxInd = 0;
        for(int i=1; i<n; i++) if(height[i] >= height[maxInd]) maxInd = i;
        int ans = 0;
        int currMaxInd = 0;
        for(int i=1; i<maxInd; i++) {
            if(height[i] >= height[currMaxInd]) currMaxInd = i; 
            else ans += height[currMaxInd] - height[i];
        }
        currMaxInd = n-1;
        for(int i=n-2; i>maxInd; i--) {
            if(height[i] >= height[currMaxInd]) currMaxInd = i;
            else ans += height[currMaxInd] - height[i];
        }
        return ans;
    }
}
