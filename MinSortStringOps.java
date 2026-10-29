// https://leetcode.com/problems/minimum-operations-to-sort-a-string/description/?envType=daily-question&envId=2026-10-21
class Solution {
    public int minOperations(String s) {
        // First occurrence of smallest letter, and last occurrence of largest letter
        int smallest = 0, largest = 0;
        int n = s.length();
        for(int i=0; i<n; i++) {
            char c = s.charAt(i);
            if(c < s.charAt(smallest)) smallest = i;
            if(c >= s.charAt(largest)) largest = i;
        }
        // Largest at end
        if(largest == n-1) return isSorted(s, 0, n-2) ? 0 : 1;
        // Smallest at start
        if(smallest == 0) return isSorted(s, 1, n-1) ? 0 : 1;
        // One of the largest at start (Only smallest not at end)
        if(s.charAt(largest) == s.charAt(0) && smallest != n-1) return 2;
        // One of the smallest at end (Only largest not at start)
        if(s.charAt(smallest) == s.charAt(n-1) && largest != 0) return 2;
        // Smallest and largest in the middle
        if(smallest != 0 && s.charAt(n-1) != s.charAt(smallest) && largest != n-1 && s.charAt(0) != s.charAt(largest) ) {
            return 2;
        }
        // Largest at start and smallest at end
        if(smallest == n-1 && largest == 0 && n > 2) return 3;
        return -1;
    }

    public boolean isSorted(String s, int start, int end) {
        for(int i=start+1; i<=end; i++) {
            if(s.charAt(i) < s.charAt(i-1)) return false;
        }
        return true;
    }
}
