class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] premax = new int[arr.length] ;
        int[] sufmin = new int[arr.length] ;

        premax[0] = arr[0] ;
        sufmin[arr.length-1] = arr[arr.length-1] ;

        for(int i = 1; i<arr.length; i++) premax[i] = Math.max(arr[i], premax[i-1]) ;
        for(int i = arr.length -2; i >= 0; i--) sufmin[i] = Math.min(arr[i], sufmin[i+1]) ;

        int c = 0; 

        for(int i = 0; i<arr.length - 1; i++) {
            if(premax[i] <= sufmin[i+1]) c++;
        }
        return c + 1 ;
    }
}