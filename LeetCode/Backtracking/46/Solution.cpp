#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<vector<int> > permute(vector<int>& nums) {
        vector<vector<int> > solution;
        vector<int> temp;
        vector<int> used(nums.size(), 0);
        Backtracking(solution, nums, temp, used, 0);
        return solution;
    }

    void Backtracking(vector<vector<int> >& solution, vector<int> nums, vector<int>& temp, vector<int>& used, int depth) {
        if(depth == nums.size()) {
            solution.push_back(temp);
            return;
        }

        for(int i = 0; i < nums.size(); i++)
            if(used[i] == 0) {
                temp.push_back(nums[i]);
                used[i] = 1;
                Backtracking(solution, nums, temp, used, depth+1);
                temp.pop_back();
                used[i] = 0;
            }
    }
};

void printResult(const vector<vector<int> >& result) {
    cout << "[";
    for (const auto& vec : result) {
        cout << "[";
        for (size_t i = 0; i < vec.size(); ++i) {
            cout << vec[i];
            if (i != vec.size() - 1) {
                cout << ",";
            }
        }
        cout << "]";
        if (&vec != &result.back()) {
            cout << ",";
        }
    }
    cout << "]";
}

int main() {
    Solution solution;
    vector<int> nums;
    nums.push_back(1);
    nums.push_back(2);
    nums.push_back(3);

    vector<vector<int> > result = solution.permute(nums);

    cout << "Generated Output: ";
    printResult(result);
    cout << endl;

    return 0;
}
