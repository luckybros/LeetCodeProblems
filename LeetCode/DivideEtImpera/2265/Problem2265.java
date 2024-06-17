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

    class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private int solution = 0;

    public int averageOfSubtree(TreeNode root) {
        // se è una foglia
        helper(root);
        return solution;
    }

    public Pair helper(TreeNode root) {
        // se è una foglia, caso base
        if(root== null)  {
            return new Pair(0, 0);
        }

        Pair leftPair = helper(root.left);
        Pair rightPair = helper(root.right);

        int numNodes = 1 + leftPair.first + rightPair.first;
        int sum = root.val + leftPair.second + rightPair.second;

        if(sum/numNodes == root.val)
            solution++;

        return new Pair(numNodes, sum);
    }
}