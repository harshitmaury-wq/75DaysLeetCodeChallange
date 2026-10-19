class Solution {
    public int largestRectangleArea(int[] heights) {
        // for each height , what max width you can achieve

        int[] nsle = nsl(heights) ;
        int[] nsri = nsr(heights) ;

        int max = Integer.MIN_VALUE ;
        for(int i = 0; i<heights.length; i++) {
            int w1 ;
            if(nsri[i] == -1) w1 = heights.length;
            else w1 = nsri[i] ;

            int w2 = nsle[i] ;
        
            max = Math.max(max, heights[i]*(w1 - w2 - 1)) ;
        }
        return max ;
    }
    int[] nsr (int[] h) {
        
        int[] idx = new int[h.length] ;
        Arrays.fill(idx, -1) ;

        Stack<Integer> st = new Stack<>() ;

        for(int i  = 0; i<h.length; i++) {
            if(st.isEmpty()) st.push(i) ;

            else {
                while(!st.isEmpty() && h[i] < h[st.peek()]){
                    idx[st.pop()] = i ;
                }
                st.push(i) ;
            }
        }
        return idx ;
    }

    int[] nsl (int[] h) {
         int[] idx = new int[h.length] ;
        Arrays.fill(idx, -1) ;

        Stack<Integer> st = new Stack<>() ;

        for(int i  = h.length-1; i>=0; i--) {
            if(st.isEmpty()) st.push(i) ;

            else {
                while(!st.isEmpty() && h[i] < h[st.peek()]){
                    idx[st.pop()] = i ;
                }
                st.push(i) ;
            }
        }
        return idx;
    }
}