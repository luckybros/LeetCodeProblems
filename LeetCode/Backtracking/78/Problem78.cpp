#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> result;
        vector<int> subvector;
        Backtracking(nums, subvector, result, 0);
        return result;
    }

    void Backtracking(vector<int>& nums, vector<int>& subvector, vector<vector<int>>& result, int count) {
        if (count == nums.size()) {
            result.push_back(subvector);
            return;
        }
        subvector.push_back(nums[count]);
        Backtracking(nums, subvector, result, count + 1);

        subvector.pop_back();
        Backtracking(nums, subvector, result, count + 1);
    }
};

void printVector(vector<vector<int>>& vec) {
    cout << "Output: [";
    for (const auto& v : vec) {
        cout << "[";
        for (size_t i = 0; i < v.size(); ++i) {
            cout << v[i];
            if (i < v.size() - 1) {
                cout << ",";
            }
        }
        cout << "]";
    }
    cout << "]" << endl;
}

int main() {
    Solution solution;
    vector<int> nums;
    nums.push_back(1);
    nums.push_back(2);
    nums.push_back(3);
    vector<vector<int>> output = solution.subsets(nums);

    cout << "Input: [";
    for (size_t i = 0; i < nums.size(); ++i) {
        cout << nums[i];
        if (i < nums.size() - 1) {
            cout << ",";
        }
    }
    cout << "]" << endl;

    printVector(output);

    return 0;
}
