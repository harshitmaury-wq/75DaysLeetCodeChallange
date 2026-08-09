class Node{
    int val ;
    Node next;
    Node prev;
    int k;
    Node(int val, int key) {
        this.val = val;
        this.next = null;
        this.prev = null ;
        this.k = key ;
    }
}

class LRUCache {

    HashMap<Integer, Node> hm ;
    int n ;
    Node head;
    Node tail ;
    
    public LRUCache(int capacity) {
        this.hm = new HashMap<>() ;
        this.n = capacity ;
        this.head = null;
        this.tail = null ;
    }
    
    public int get(int key) {
        if(!hm.containsKey(key)) return -1;
        
        Node n = hm.get(key) ;
        int temp = n.val ;
        
        Node newnode = new Node(temp, key) ;
        head.next = newnode;
        newnode.prev = head ;
        head = newnode ;

        if(tail == n) {
            tail = tail.next;
            tail.prev = null ;
        }
        else {
            n.prev.next = n.next;
            n.next.prev = n.prev ;
    
        }

        hm.put(key, newnode) ;
        return temp ;
    }
    
    public void put(int key, int value) {
        Node newnode = new Node(value, key) ;
        if(hm.containsKey(key)) {
            Node temp = hm.get(key) ;
            hm.put(key, newnode) ;

            head.next = newnode;
            newnode.prev = head ;
            head = newnode;

            if(temp == tail) {
                tail = tail.next;
                tail.prev = null ;
            }
            else {
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev ;
            }

            

        }
        else {
            if(n == 0) {
                if(head == tail) {hm.remove(head.k) ;head = tail = null ;}
                else {
                    hm.remove(tail.k) ;
                    tail = tail.next;
                    tail.prev = null ;
                }
                n++;
            }
            if(head == null) {
                head = newnode;
                tail = newnode;
            }
            
            else {
                head.next = newnode;
                newnode.prev = head ;
                head = newnode;   
            }
            n--;
            hm.put(key, newnode) ;
        }
    
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */