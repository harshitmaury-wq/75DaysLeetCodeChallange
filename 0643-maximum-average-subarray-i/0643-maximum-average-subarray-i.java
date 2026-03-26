class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double avg; 
        int i=0;
        int j=0;
        double sum=0;
        double max;
        while(j<k){
            sum=sum+nums[j];
            j++;
        }
         max=sum/k;
         while(j<nums.length){
            avg=sum/k;
            if(avg>max) max=avg;
            sum=sum-nums[i];
            i++;
            sum=sum+nums[j];
            j++;
         }
         max = Math.max(max, sum/k);
         return max;
    }
}