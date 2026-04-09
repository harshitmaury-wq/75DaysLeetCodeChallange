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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ArrayList<Integer> list = new ArrayList<>() ;

        while(list1 != null) {
            list.add(list1.val) ;
            list1 = list1.next;
        }
        while(list2 != null) {
            list.add(list2.val) ;
            list2 = list2.next;
        }
        Collections.sort(list) ;

        ListNode head = new ListNode();
        ListNode temp = head ;
        for(int i=0; i<list.size(); i++){
            ListNode node = new ListNode() ;
            node.val = list.get(i) ;
            temp.next = node ;
            temp = node;
        }
        return head.next;
    }
}