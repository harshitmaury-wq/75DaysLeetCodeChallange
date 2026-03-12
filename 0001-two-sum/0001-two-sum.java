class Solution {
    public int[] twoSum(int[] nums, int target) {
      int[] answer=new int[2];
      int sum=0;
        HashMap<Integer,Integer> hm= new HashMap<>(); 
        for(int i=0; i<nums.length; i++){
            if(hm.containsKey(target-nums[i])){
                answer[0]=i;
                answer[1]=hm.get(target-nums[i]);
            }
            else hm.put(nums[i],i);
            
        }
       return answer; 
    }
}