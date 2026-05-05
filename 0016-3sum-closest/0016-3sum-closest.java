class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ANS = nums[0]+nums[1]+ nums[2];
        for(int i = 0; i< nums.length-2; i++){
            int j = i+1; 
            int k = nums.length-1;
          
            int ans = nums[i]+ nums[j]+ nums[j+1];

            while(j<k){
               int sum=(nums[i]+nums[j]+nums[k]);
               if(Math.abs(sum-target)<Math.abs(ans-target)) ans = sum;
                if(sum<target){ j++;}
                if(sum>target){ k--;}
                if(sum==target) break;
            }
            if(Math.abs(ans-target)<Math.abs(ANS-target)) ANS = ans;

        }
        return ANS;
    }
}