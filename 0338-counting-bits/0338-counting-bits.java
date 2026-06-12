class Solution {
    public int[] countBits(int n) {
        int[] arr=new int[n+1];
        int j=0;
        for(int i=0;i<=n ;i++){
            arr[j]=nosb(i);
            j++;
        }
        return arr;
    }
    static int nosb(int n){
        int count=0;
        while(n!=0){
            n= n & (n-1);
            count++;
        }
        return count;
    }
}