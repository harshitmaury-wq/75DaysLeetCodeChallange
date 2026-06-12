class Solution {
    public int clumsy(int n) {
        Stack<Integer> st = new Stack<>() ;
        int c = 0;
        st.push(n) ;

        for(int i = n-1 ; i >= 1 ; i--){
            if(c==0) st.push(st.pop()*i) ;
            else if(c==1) st.push((int)Math.floor(st.pop()/i)) ;
            else if(c == 2) { st.push(i) ;}
            else if(c == 3) {  st.push(-1 * i) ;}

            c++;
            if(c == 4) c = 0;
            
        }
        int ans = 0;
        while(!st.isEmpty()) {
            ans += (st.pop() ) ;
        }
        return ans ;
    }
}