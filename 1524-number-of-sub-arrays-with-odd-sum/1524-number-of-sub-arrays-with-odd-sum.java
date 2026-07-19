class Solution {
    public int numOfSubarrays(int[] arr) {
        int[] pre = new int[arr.length] ;
        pre[0] = arr[0] ;
        int c = 0;
        if(pre[0] % 2 == 1) c++;
        for(int i = 1; i<arr.length; i++) {
        pre[i] = pre[i-1] + arr[i] ;
        if(pre[i]%2==1) c++ ;
        c%=1000000007 ;
        }
        int[] even = new int[arr.length] ;
        int[] odd = new int[arr.length] ;
        if(pre[arr.length-1] % 2 == 0) even[arr.length-1] ++;
        else odd[arr.length-1] ++;
        for(int i =arr.length-2; i>=0; i--){
            if(pre[i] %2 == 0) {even[i] = even[i+1] + 1 ; odd[i] = odd[i+1] ;}
            else {odd[i] = odd[i+1] + 1; even[i] = even[i+1] ;}
        }
        for(int i = 0; i<arr.length-1; i++) {
            if(pre[i] %2 ==0) c+=odd[i+1] ;
            else c+=even[i+1] ;
            c%=1000000007 ;
        }
        return c ;
    }
}