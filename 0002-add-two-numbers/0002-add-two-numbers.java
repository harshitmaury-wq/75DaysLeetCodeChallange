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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;

        ListNode aux = new ListNode(0, null);
        ListNode ans = aux;

        while(l1 != null && l2 != null){
            int temp = l1.val + l2.val + carry;
            carry = 0;
            aux.next = new ListNode(temp%10, null);
            aux = aux.next;
            carry = temp/10;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            int temp = l1.val + carry ;
            carry = 0;
            aux.next = new ListNode(temp%10, null);
            aux = aux.next;
            carry = temp/10;
             l1 = l1.next;
        }

            while(l2 != null){
            int temp = l2.val + carry ;
            carry = 0;
            aux.next = new ListNode(temp%10, null);
            aux = aux.next;
            carry = temp/10;
            l2 = l2.next;
        }

        if(carry != 0) {
             aux.next = new ListNode(carry, null);
            aux = aux.next;
        }

        return ans.next ;
        
    }
    
}