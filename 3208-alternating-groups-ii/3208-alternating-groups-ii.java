class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int[] temp = new int[2*colors.length] ;

        int j = 0;
        int l = colors.length ;
        for(int i = 0; i<colors.length; i++) {
            temp[j] = colors[i] ;
            temp[l] = colors[i] ;
            j++;
            l++;
        }


        int count = 0;

        int last = temp[0] ;
        
        int size = 1;
        for(int i = 1; i<=colors.length-1+k-1 ; i++) {
            
            if(temp[i] == last) {
                if(size >= k)count += (size - (k-1)) ;

               
                size = 0 ;
            }

            last = temp[i] ;
            size++ ;
        }

        if(size >= k)count += (size - (k-1)) ;

        return count ;
    }
}