/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* reverseList(struct ListNode* head) {
    struct ListNode* temp = head;
    int arr[5002];
    int i=0;
    while(temp != NULL) {
        arr[i] = temp -> val;
        i++;
        temp = temp -> next;
    }
    temp = head;
    i--;
    while(temp  != NULL) {
        temp -> val = arr[i];
        i--;
        temp = temp -> next;
    }

    return head;
}