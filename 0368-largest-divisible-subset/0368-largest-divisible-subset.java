class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int[][] dp = new int[nums.length+1][nums.length+1];
        for(int[]ele : dp) Arrays.fill(ele, -1);
        fun(nums, 0, -1, dp);
        build(list, 0, -1, nums, dp);
        return list;

    }
    static int fun(int[]arr, int s, int p, int[][] dp){
        if(s==arr.length) return 0;

        if(dp[s][p+1] != -1) return dp[s][p+1];
        int skip, take = Integer.MIN_VALUE;
         if(p == -1 || arr[s]%arr[p]==0) {
             take = 1 + fun(arr, s+1, s, dp);
             skip = fun(arr, s+1, p, dp);
        }
        else{
             skip = fun(arr, s+1, p, dp);
        }
        return dp[s][p+1] = Math.max(take, skip);
    }
    static void build (List<Integer> list, int s, int p, int[]arr, int[][]dp ){
        if(s==arr.length) return;
        
         int skip = dp[s+1][p+1];
    int take = Integer.MIN_VALUE;

    if (p == -1 || arr[s] % arr[p] == 0) {
        take = 1 + dp[s+1][s+1];
    }
        if(take>skip){
            list.add(arr[s]);
            build(list, s+1, s, arr, dp);
        }
        else {
             build(list, s+1, p, arr, dp);
        }

    }
}