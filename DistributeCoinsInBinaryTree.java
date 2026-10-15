// https://leetcode.com/problems/distribute-coins-in-binary-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans = 0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode curr) {
        if(curr == null) return 0;
        int left = dfs(curr.left);
        int right = dfs(curr.right);
        ans += Math.abs(left) + Math.abs(right);
        return (curr.val - 1) + left + right;
    }
}
