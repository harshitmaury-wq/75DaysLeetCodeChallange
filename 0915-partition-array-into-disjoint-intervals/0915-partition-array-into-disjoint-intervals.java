class Solution {
    public int partitionDisjoint(int[] nums) {
        int[] premax = new int[nums.length];
        int[] sufmin = new int[nums.length];


       premax[0] = nums[0];
       sufmin[nums.length-1] = nums[nums.length-1];

       for(int i=1; i<nums.length; i++){
        premax[i] = Math.max(premax[i-1], nums[i]);
       }

       for(int i=nums.length-2; i>=0; i--){
        sufmin[i] = Math.min(sufmin[i+1], nums[i]);
       }

        for(int i=0; i<nums.length; i++){
            if(premax[i] <= sufmin[i+1]) return i+1;
        }


        return -1;
    }
}