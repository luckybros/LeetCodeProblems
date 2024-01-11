#include <iostream>
#include <utility>
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
    int averageOfSubtree(TreeNode* root) {
        int solution = 0;
        calculateSumAndCount(root, solution);
        return solution;
    }

    pair<int, int> calculateSumAndCount(TreeNode* root, int &solution) {
        if(root == NULL)
            return make_pair(0, 0);

        pair<int, int> leftSubtree = calculateSumAndCount(root->left, solution);
        pair<int, int> rightSubtree = calculateSumAndCount(root->right, solution);

        int sum = root->val + leftSubtree.first + rightSubtree.first;
        int nodeCount = 1 + leftSubtree.second + rightSubtree.second;

        if(root->val == sum/nodeCount)
            solution++;

        return make_pair(sum, nodeCount);
    }
};

int main() {
    TreeNode* root = new TreeNode(4);
    root->left = new TreeNode(8);
    root->right = new TreeNode(5);
    root->left->left = new TreeNode(0);
    root->left->right = new TreeNode(1);
    root->left->right->left = nullptr;
    root->left->right->right = new TreeNode(6);

    Solution solution;
    int result = solution.averageOfSubtree(root);
    cout << "Number of nodes where the value is equal to the average of its subtree: " << result << std::endl;

    delete root->left->left;
    delete root->left->right->right;
    delete root->left->right;
    delete root->right;
    delete root->left;
    delete root;

    return 0;
}
