/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* insertAtPos(ListNode* head, ListNode* nodeToAdd) {
        if (!head || !nodeToAdd)
            return NULL;

        ListNode* curr = head;
        if (nodeToAdd->val <= curr->val) {
            nodeToAdd->next = head;
            return nodeToAdd;
        } else {
            while (curr && curr->next && nodeToAdd->val > curr->next->val)
                curr = curr->next;
            ListNode* next = curr->next;
            curr->next = nodeToAdd;
            nodeToAdd->next = next;
        }
        return head;
    }
    ListNode* insertionSortList(ListNode* head) {
        ListNode *curr = head->next, *prev = head;
        while (curr) {
            ListNode* next = curr->next;
            if (curr->val >= prev->val) {
                prev = curr;
                curr = next;
                continue;
            }
            prev->next = next;
            head = insertAtPos(head, curr);
            curr = next;
        }
        return head;
    }
};