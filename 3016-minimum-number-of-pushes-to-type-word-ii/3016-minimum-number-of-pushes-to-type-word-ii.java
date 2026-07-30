class Solution {
    public int minimumPushes(String word) {
        
        int[][] arr= new int[26][2] ;
        
        for(int i = 0; i<word.length(); i++) {
            
           arr[word.charAt(i) - 'a'][0] ++ ;
            
        }
        Arrays.sort(arr, (a, b) -> {return b[0]-a[0] ;} ) ;

        int c = 1;
        int cl = 1;
        int ans = 0;
        for(int i = 0; i<26; i++) {
            if(arr[i][0] == 0) break ;

            
            ans += (cl*arr[i][0]) ;
            c++;
            if(c == 9) {c = 1; cl++; }
           
           
        }
        
        
        return ans ;
    }
}