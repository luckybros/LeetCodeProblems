#include <vector>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};
 
class Solution {
public:
    ListNode* sortList(ListNode* head) {
        vector<int> nums;
        PopulateArray(nums, head);
        sort(nums.begin(), nums.end());
        ListNode* newHead = CreatingNewList(nums);
        return newHead;
    }

    void PopulateArray(vector<int>& nums, ListNode* head) {
        ListNode* temp = head;
        while(temp != NULL) {
            nums.push_back(temp->val);
            temp = temp->next;
        }
    } 

    ListNode* CreatingNewList(vector<int> nums) {
        if(nums.empty())
            return NULL;

        int i = 1;
        ListNode* head = new ListNode(nums[0]);
        ListNode* temp = head;
        while(i < nums.size()) {
            ListNode* temp1 = new ListNode(nums[i]);
            temp->next = temp1;
            temp = temp->next;
            i++;
        }
        return head;
    }
};