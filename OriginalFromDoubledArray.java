// https://leetcode.com/problems/find-original-array-from-doubled-array/
class Solution {
    public int[] findOriginalArray(int[] changed) {
        Arrays.sort(changed);
        int right = 1;
        int ansInd = 0;
        int[] ans = new int[changed.length/2];
        Set<Integer> usedIndices = new HashSet<>();
        for(int i=0; i<changed.length; i++) {
            if(!usedIndices.contains(i)) {
                usedIndices.add(i);
                while(right < changed.length && (changed[right] != 2 * changed[i] || usedIndices.contains(right))) {
                    right++;
                }
                if(right == changed.length) return new int[] {};
                else {
                    usedIndices.add(right);
                    ans[ansInd++] = changed[i];
                    right++;
                }
            }
        }
        return ans;
    }
}
