class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> ans = new  ArrayList<>() ;

        int i = 0;
        int j = arr.length - 1 ;
        while(j > i) {
            int maxidx = 0;
            for(int k = 0; k<=j; k++) {
                if(arr[k] > arr[maxidx]) maxidx = k ;
            }
            if(maxidx==j) {j--; continue;}
            if(maxidx!=0) {
            int s = 0;
            int e = maxidx ;
            while(s<=e){
            
            swap(arr, s, e) ;
            
            s++; e--;
            }
            }
            ans.add(maxidx+1) ;
            
            int s = 0;
            int e = j ;
            while(s<=e) {
            swap(arr, e, s) ;
            s++; e--;
            }
            ans.add(j+1) ;
            j--;
        }

        return ans ;
    }
    void swap(int[] arr, int a, int b) {
        int temp = arr[a] ;
        arr[a] = arr[b] ;
        arr[b] = temp ;
    }
}