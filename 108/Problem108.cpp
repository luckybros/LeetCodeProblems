#include <iostream>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {
public:
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        if(nums.empty())
            return NULL;

        int middle = nums.size()/2;
        vector<int> leftArray(nums.begin(), nums.begin()+middle);
        vector<int> rightArray(nums.begin()+middle+1, nums.end());
        TreeNode* left = sortedArrayToBST(leftArray);
        TreeNode* right = sortedArrayToBST(rightArray);
        TreeNode* root = new TreeNode(nums[middle], left, right);

        return root;
    }
};

