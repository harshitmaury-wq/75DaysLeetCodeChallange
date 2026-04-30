class Solution {
    public int longestConsecutive(int[] nums) {
        TreeSet<Integer>ts=new TreeSet<>();
        int max=0;
        int count=1;
        for(int i=0; i<nums.length; i++){
            ts.add(nums[i]);
        }
        for(Integer i: ts){
            if(ts.contains(i+1)) count++;
            else{
                
                if(count>max){
                    max=count;
                    count=1;
                }
                else count=1;
            }
        }
        return  max;
    }
}