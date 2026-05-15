/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode h = head;
        ListNode temp = head ;

        while(temp != null){
            ListNode t = temp;
            while(temp!=null && t.next != null && temp.val == t.next.val) t = t.next;

            temp.next = t.next;
            temp = temp.next ;
        }
        return h;
    }
}