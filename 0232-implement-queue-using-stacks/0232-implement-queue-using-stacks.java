class MyQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
       
        s2.push(x);
    }
    
    public int pop() {
        
            while(!s2.isEmpty()) s1.push(s2.pop());
            int t = s1.pop();
            while(!s1.isEmpty()) s2.push(s1.pop());
            return t;
        
    }
    
    public int peek() {
         while(!s2.isEmpty()) s1.push(s2.pop());
            int t = s1.peek();
            while(!s1.isEmpty()) s2.push(s1.pop());
        return t;
    }
    
    public boolean empty() {
        if(s2.isEmpty() ) return true;
        else return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */