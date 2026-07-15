class Solution {
    public int longestMountain(int[] arr) {
        int i = 1; 
        int max = Integer.MIN_VALUE ;
        while(i<arr.length-1) {

            if(arr[i] > arr[i-1] && arr[i] > arr[i+1]){
                int l = i-1;
                int r = i+1;
                while(l>=0 && arr[l] < arr[l+1]) l--;
                while(r<arr.length && arr[r] < arr[r-1]) r++ ;

                max = Math.max(max, r-l-1) ;
                i = r  ;
            }
            else i++;
        }
        if(max == Integer.MIN_VALUE) return 0 ;
        return max ;
    }
}