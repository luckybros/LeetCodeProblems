#include<vector>
#include<iostream>
using namespace std;
#define N 200

class Solution {
public:
    int rob(vector<int>& nums) {
        return max(Recursive(nums, 0),Recursive(nums, 1));
    }
    int Recursive(vector<int> nums, int index) {
        if(index > nums.size()-1)
            return 0;
        return max(nums[index] + Recursive(nums, index+2), nums[index] + Recursive(nums, index+3));
    }
};

int main() {
    Solution soluzione;
    vector<int> nums;
    for(int i = 0; i < N; i++)
        nums.push_back(i);

    cout << soluzione.rob(nums);

}
