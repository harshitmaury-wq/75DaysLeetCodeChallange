class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        int s = 0;
        ListNode temp = head;

       
        while(temp != null){
            s++;
            temp = temp.next;
        }

        int k = s - n + 1;

       
        if(k == 1) return head.next;

        ListNode p = head;
        temp = head;

       
        for(int i = 1; i < k; i++){
            p = temp;
            temp = temp.next;
        }

       
        p.next = temp.next;

        return head;
    }
}