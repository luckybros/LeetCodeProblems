#include <iostream>
#include <vector>
#include <algorithm>
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
};

int main() {
    Solution solution;
    int x[] = {1,2,3,1};
    vector<int> nums(begin(x), end(x));
    cout << solution.containsDuplicate(nums);
    return 0;
}