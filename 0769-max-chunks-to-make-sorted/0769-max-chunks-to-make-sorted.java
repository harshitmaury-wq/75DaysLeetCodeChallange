class Solution {
    public int maxChunksToSorted(int[] arr) {
        int c = 0;
        int[] ar = new int[arr.length] ;

        for(int i = 0; i<arr.length; i++){
            ar[arr[i]] = 1 ;
            boolean b = true ;
            for(int j = 0; j<= i; j++){
                if(ar[j] == 0){b = false ; break ;}
            }
            if(b) c++;
        }
        return c ;
    }
}