class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] ans = new int[queries.length] ;
        Arrays.sort(nums) ;
        int[][] que = new int[queries.length][2] ;
        for(int i = 0; i<que.length; i++){
            que[i][0] = queries[i] ;
            que[i][1] = i;
        }
        Arrays.sort(que, (a, b) -> {return a[0] - b[0] ;}) ;
        int sum = 0;
        int q = 0 ;
        int i = 0;
        for( i = 0; i<nums.length && q<ans.length; i++) {
            sum+=nums[i] ;
            while(q<ans.length && sum > que[q][0]) {
                ans[que[q][1]] = i ;
                q++;
            }
        }

        if(i == nums.length) {
            while(q < ans.length) {ans[que[q][1]] = nums.length ; q++; }
        }

        return ans;
    }
}