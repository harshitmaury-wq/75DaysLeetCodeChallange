class BrowserHistory {
    Stack<String> backward = new Stack<>() ;
    Stack<String> forward = new Stack<>() ;

    String curr; 

    public BrowserHistory(String homepage) {
        backward.push(homepage) ;
        curr = backward.peek() ;
    }
    
    public void visit(String url) {
        backward.push(url) ;
        curr = backward.peek() ;

        forward.clear() ;
    }
    
    public String back(int steps) {

        while(steps > 0 && backward.size() > 1) {
            forward.push(backward.pop()) ;
            steps -- ;
        }
        curr = backward.peek() ;
        return curr ;
        
    }
    
    public String forward(int steps) {
        
        while(steps > 0 && forward.size() >= 1) {

            backward.push(forward.pop()) ;
            steps -- ;
        }

        curr = backward.peek() ;
        return curr ;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */