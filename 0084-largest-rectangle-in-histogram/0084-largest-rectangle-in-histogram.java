class Solution {
    public int largestRectangleArea(int[] h) {

        if(h.length == 1) return h[0] ;
        Stack<Integer> s = new Stack<>() ;

        int[] nsr = new int[h.length] ;
        Arrays.fill(nsr, -1) ;

        int i = 0;
        while(i<h.length){
            if(s.isEmpty()) s.push(i);
            else {
                while(!s.isEmpty() && h[s.peek()]>h[i]) nsr[s.pop()] = i ;
            }
            s.push(i); i++ ;
        }
        int[] nsl = new int[h.length] ;
        Arrays.fill(nsl, -1) ;

        s.clear() ;
        i  = h.length-1 ;
        while(i>=0  ){
            if(s.isEmpty()) s.push(i);
            else {
                while(!s.isEmpty() && h[s.peek()]>h[i]) nsl[s.pop()] = i ;
            }
            s.push(i); i-- ;
        }

        int max = Integer.MIN_VALUE ;

        for(i= 0; i< h.length; i++){
            int w1;
            if(nsr[i]==-1) w1 = h.length;
            else w1 = nsr[i] ;

            int w2 ;
            if(nsl[i]==-1) w2 = -1;
            else w2 = nsl[i] ; 

            max = Math.max(max, (w1-w2-1)*h[i]) ;
            
        }

        return max;
    }

}