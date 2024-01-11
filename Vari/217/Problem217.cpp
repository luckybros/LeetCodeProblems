#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_set>
using namespace std;

class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        for(int i = 0; i < nums.size() - 1; i++)
            if(nums[i] == nums[i+1])
                return true;
        return false;
    }

    bool containsDuplicateLinear(vector<int>& nums) {
        unordered_set<int> seen;
        for(int num: nums) {
            if(seen.count(num) > 0)
                return true;
            seen.insert(num);
        }
        return false;
    }
};

int main() {
    Solution solution;
    int x[] = {1,2,3,1};
    vector<int> nums(begin(x), end(x));
    cout << solution.containsDuplicateLinear(nums);
    return 0;
}