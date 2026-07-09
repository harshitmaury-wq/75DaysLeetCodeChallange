class Solution {
    public int longestSubarray(int[] nums) {
        int i = 0;
        int max = 0;
        int res = 0;
        int z = 0;
        int j = 0;
        while(j < nums.length){
            if(nums[j] == 1) {res++; max = Math.max(max, res); j++; }
            else {
                if(z == 0) {z++; j++;}
                else {
                    while(z > 0){
                        res -= nums[i];
                        if(nums[i]==0) z--;
                        i++;
                    }
                }
                
            }
        }
         return max == nums.length ? nums.length-1 : max ;
    }
}