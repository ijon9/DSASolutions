// https://leetcode.com/problems/most-beautiful-item-for-each-query/
class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a,b) -> a[0] - b[0]);
        List<int[]> pruned = new ArrayList<>();
        int maxBeauty = items[0][1];
        pruned.add(items[0]);
        for(int i=1; i<items.length; i++) {
            if(items[i][1] > maxBeauty) {
                maxBeauty = items[i][1];
                pruned.add(items[i]);
            }
        }
        int[] ans = new int[queries.length];
        for(int i=0; i<queries.length; i++) {
            int left = 0, right = pruned.size()-1;
            while(left != right) {
                int mid = (left + right + 1) / 2;
                if(pruned.get(mid)[0] <= queries[i]) {
                    left = mid;
                } else {
                    right = mid-1;
                }
            }
            if(pruned.get(left)[0] <= queries[i]) ans[i] = pruned.get(left)[1];
        }
        return ans;
    }
}
