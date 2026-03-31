class MinStack {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        if(s1.isEmpty() && s2.isEmpty()) {
            s1.push(val);
            s2.push(val);
        }
        else {
            s1.push(val);
            s2.push(Math.min(val, s2.peek()));
        }
    }
    
    public void pop() {
        s1.pop();
        s2.pop();
    }
    
    public int top() {
        return s1.peek();
    }
    
    public int getMin() {
        return s2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */