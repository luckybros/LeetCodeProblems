#include <iostream>

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        ListNode* headCopy = head;
        while(headCopy && headCopy->next) {
            if(headCopy->val == headCopy->next->val) 
                headCopy->next = headCopy->next->next;
            else headCopy = headCopy->next;
        }
        return head;
    }
};

void printList(ListNode* head) {
        while (head != nullptr) {
            std::cout << head->val;
            if (head->next) {
                std::cout << " -> ";
            }
            head = head->next;
        }
        std::cout << std::endl;
}

int main() {
    ListNode* head = new ListNode(1);
    head->next = new ListNode(1);
    head->next->next = new ListNode(2);
    head->next->next->next = new ListNode(3);

    Solution solution;
    std::cout << "Input: ";
    printList(head);

    ListNode* result = solution.deleteDuplicates(head);

    std::cout << "After removing duplicates: ";
    printList(result);

    return 0;
}