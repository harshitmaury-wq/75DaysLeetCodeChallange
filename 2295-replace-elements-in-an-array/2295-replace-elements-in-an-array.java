class Solution {
    public int[] arrayChange(int[] nums, int[][] op) {
        int[] arr= new int[1000001] ;
        Arrays.fill(arr, -1) ;

        for(int i =0; i<nums.length; i++) arr[nums[i]] = i;

        for(int i =0; i<op.length; i++) {
            arr[op[i][1]] = arr[op[i][0]];
            arr[op[i][0]] = -1;
        }

        int[] ans = new int[nums.length] ;

        for(int i = 0; i<arr.length; i++){
        if(arr[i] == -1) continue;
        ans[arr[i]] = i ;
        }
        return ans;
    }
}