class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[] arr = new int[matrix[0].length] ;
        
        int max = Integer.MIN_VALUE ;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                if(matrix[i][j]=='0') arr[j] = 0;
                else arr[j] += 1 ;
            }
            max = Math.max(max, area(arr)) ;
        }
        return max;

        
    }
    static int area (int[] height){
        Stack<Integer> st = new Stack<>() ;

        int[] nsl = new int[height.length] ;
        int[] nsr = new int[height.length] ;
        Arrays.fill(nsr, -1) ;
        Arrays.fill(nsl, -1) ;

        int i = 0;
    
        while(i<height.length) {
            
            while(!st.isEmpty() && height[i] < height[st.peek()]) nsr[st.pop()] = i ;
            st.push(i) ;
            i++;
        }
        st.clear();
        i = height.length-1;
    
        while(i>=0) {
            
            while(!st.isEmpty() && height[i] < height[st.peek()]) nsl[st.pop()] = i ;
            st.push(i) ;
            i--;
        }
        int max = Integer.MIN_VALUE;
        for(i=0; i < height.length; i++){

            int w1;
            if(nsr[i] == -1) w1 = height.length ;
            else w1 = nsr[i] ;

            int w2;
            if(nsl[i] == -1) w2 = -1;
            else w2 = nsl[i] ;

            max = Math.max(max, (w1 - w2 -1)*height[i] ) ;

        }
        return max;

    }
}