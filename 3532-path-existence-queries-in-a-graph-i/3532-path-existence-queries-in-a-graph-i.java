class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int md, int[][] queries) {
        int[] com = new int[nums.length] ;
        com[0] =1 ;
        for(int i = 1; i<nums.length; i++){
            if(nums[i] - nums[i-1] <= md) {
                com[i] = com[i-1] ;
            }
            else {
                com[i] = com[i-1] + 1 ;
            }
        }
        boolean[] ans = new boolean[queries.length] ;
        for(int i = 0; i<queries.length; i++){
            if(com[queries[i][0]] == com[queries[i][1]]) ans[i] = true;
            else ans[i] = false ;
        }
        return ans ;
    }
}