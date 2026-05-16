/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA ;
        ListNode b = headB;

        HashSet<ListNode> hs = new HashSet<>() ;

        while(a!=null){
            hs.add(a);
            a= a.next;
        }

        while(b!=null){
            if(hs.contains(b)) return b;
            b = b.next;
        }

        return null ;
    }
}