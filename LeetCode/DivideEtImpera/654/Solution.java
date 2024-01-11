class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode() {}
    
    TreeNode(int val) {
        this.val = val;
    }
    
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class MaximumBinaryTree {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 6, 0, 5};
        Solution solution = new Solution();
        TreeNode result = solution.constructMaximumBinaryTree(nums);
        printTree(result);
    }

    public static void printTree(TreeNode node) {
        if (node == null) {
            System.out.println("null");
            return;
        }
        System.out.print(node.val + " ");
        System.out.print("-> Left: ");
        printTree(node.left);
        System.out.print("-> Right: ");
        printTree(node.right);
    }
}

public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length);
    }

    public TreeNode construct(int[] nums, int l, int r) {
        if (l == r) return null;
        
        int maxIndex = calculateMax(nums, l, r);
        
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = construct(nums, l, maxIndex);
        root.right = construct(nums, maxIndex + 1, r);

        return root;
    }

    public int calculateMax(int[] nums, int l, int r) {
        int maxIndex = l;
        for (int i = l; i < r; i++)
            if (nums[i] > nums[maxIndex])
                maxIndex = i;
        return maxIndex;
    }
}
