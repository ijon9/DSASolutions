// https://leetcode.com/problems/smallest-palindromic-rearrangement-i/description/
class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        char[] ans = new char[n];
        int[] letterCount = new int[26];
        for(int i=0; i<n; i++) {
            letterCount[s.charAt(i)-'a']++;
        }
        int left = 0, right = n-1;
        for(int i=0; i<26; i++) {
            if(letterCount[i] > 0) {
                if(letterCount[i] % 2 == 1) {
                    ans[n/2] = (char) (i+'a');
                    letterCount[i]--;
                }
                for(int j=0; j<letterCount[i]; j += 2) {
                    ans[left++] = (char) (i+'a');
                    ans[right--] = (char) (i+'a');
                }
            }
        }
        return new String(ans);
    }
}
