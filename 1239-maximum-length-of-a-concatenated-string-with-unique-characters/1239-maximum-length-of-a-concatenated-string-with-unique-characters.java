class Solution {
    int size = 0 ;
    public int maxLength(List<String> arr) {
        StringBuilder sb = new StringBuilder() ;
        fun(sb, arr, 0) ;
        return size ;
    }
    void fun(StringBuilder sb, List<String> arr, int s) {
        if(s == arr.size() ) return ;
        
        int temp = sb.length() ;
        sb.append(arr.get(s)) ;
        if(unique(sb)){
            size = Math.max(size, sb.length()) ;
            fun(sb, arr, s+1);
        }
        sb.setLength(temp) ;

        fun(sb, arr, s+1) ;

    }
    boolean unique (StringBuilder sb ){
        int[] arr = new int[26] ;
        for(int i=0; i<sb.length(); i++){
            if(arr[sb.charAt(i) - 'a'] != 0) return false ;
            else arr[sb.charAt(i) - 'a']++ ; 
        }
        return true;
    }
}