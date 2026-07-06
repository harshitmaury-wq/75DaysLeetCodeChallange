class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>() ;
        int max = -1 ;
        Arrays.sort(nums) ;
        for(int i = 0; i<nums.length; i++){
            int sum = sod(nums[i]) ;
            if(hm.containsKey(sum)){
                max = Math.max(max, nums[i]+hm.get(sum)) ;
                hm.put(sum, nums[i]) ;
            }
            else hm.put(sum, nums[i]) ;
        }
        return max ;
    }
    int sod (int n){
        int s = 0;
        while(n>0){
            s+=(n%10) ;
            n/=10 ;
        }
        return s ;
    }
}