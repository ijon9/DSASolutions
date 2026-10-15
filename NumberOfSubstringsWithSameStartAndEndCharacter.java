class Solution {
    public long countSubstrings(String s, char c) {
        long ans = 0;
        int numChars = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == c) {
                numChars++;
                ans += numChars;
            }
        }
        return ans;
    }
}
