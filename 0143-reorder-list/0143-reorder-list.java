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
    public void reorderList(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode temp = head;
        while(temp != null) {
            st.push(temp);
            temp = temp.next ;
        }
        int k = st.size()/2;

        ListNode curr = head;
        while(k>0){
            temp = st.pop();
            ListNode temp2 = curr.next ;
            curr.next = temp;
            temp.next = temp2;
            curr = temp2;
            k--;
        }
        curr.next = null;
    
    }
}