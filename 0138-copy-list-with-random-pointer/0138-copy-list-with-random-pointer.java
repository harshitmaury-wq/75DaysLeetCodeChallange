/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node oldtemp = head ;
        Node newhead = new Node(head.val) ;
        Node newtemp = newhead ;

        HashMap<Node, Node> hm = new HashMap<>() ;
        oldtemp = oldtemp.next ;

        hm.put(head, newtemp) ;

        while(oldtemp != null) {
            Node newnode = new Node(oldtemp.val) ;
            newtemp.next = newnode ;
            newtemp = newtemp.next ;
            hm.put(oldtemp, newtemp) ;

            oldtemp = oldtemp.next ;
        }

        oldtemp = head ;
        newtemp = newhead ;

        while(oldtemp != null) {
            Node oldrandom = oldtemp.random ;
            Node newrandom = hm.get(oldrandom) ;

            newtemp.random = newrandom ;

            oldtemp = oldtemp.next;
            newtemp = newtemp.next ;
        }

        return newhead ;
    }
}