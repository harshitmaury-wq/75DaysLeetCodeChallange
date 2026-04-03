class Solution {
    public int getWinner(int[] arr, int k) {
        int curr = arr[0];
        int max = arr[0];
        int win = 0;
        for(int i : arr) max = Math.max(max, i);

        for(int i=1; i<arr.length; i++){
            if(curr > arr[i]){
                win++;

            }
            else {
                curr = arr[i];
                win = 1;
            }
            if(win == k) return curr;
        }
        return max;
    }
}