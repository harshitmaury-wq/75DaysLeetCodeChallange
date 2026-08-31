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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        
        if(head.next == null || head.next.next == null) return new int[]{-1, -1} ;

        int leftmostcritical = -1 ;
        int recent = -1 ;
        ListNode one = head ;
        ListNode two = head.next ;
        ListNode three = head.next.next ;

        int min = Integer.MAX_VALUE ;
        int max = -1 ;
        int c = 2 ;
        while(three != null) {
            if((two.val > one.val && two.val > three.val) || (two.val < one.val && two.val < three.val)){
                if(leftmostcritical == -1) {
                    leftmostcritical = c ;
                    recent = c ;
                }

                else {
                    min = Math.min(min, c - recent) ;
                    recent = c ;
                }
            }
              c++;
                one = one.next;
                two = two.next ;
                three = three.next ;
        }

        max = recent - leftmostcritical ;
        if(min == Integer.MAX_VALUE) return new int[]{-1, -1} ;
        return new int[]{min, max} ;
    }
}