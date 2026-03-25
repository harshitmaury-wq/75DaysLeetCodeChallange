class Solution {
    public int maxProfit(int[] arr) {
        int min=arr[0];
        int diff=0;
        int mx=0;
        for(int i=0; i<arr.length ; i++){
            if(arr[i]<min) min = arr[i];
            diff = arr[i]-min;
            if(diff>mx) mx=diff;
        }
        return mx;
    }
}