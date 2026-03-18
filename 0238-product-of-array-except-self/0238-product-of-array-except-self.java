class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pp=new int[nums.length];
        int[] sp=new int[nums.length];
        int[] an=new int[nums.length];
        pp[0]=nums[0];
        sp[nums.length-1]=nums[nums.length-1];
        for(int i=1; i<nums.length; i++){
            pp[i]=pp[i-1]*nums[i];
        }
        for(int i=nums.length-2; i>=0; i--){
            sp[i]=nums[i]*sp[i+1];
        }
        for(int i=0; i<nums.length; i++){
            if(i==0) an[i]=sp[i+1];
            else if (i==nums.length-1) an[i]=pp[i-1];
            else an[i]=pp[i-1]*sp[i+1];
        }
        return an;
    }
}