class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums) ; 
        List<List<Integer>> ans = new ArrayList<>() ;

        for(int k = 0; k <= nums.length-3 ; k++) {
            if(k > 0 && nums[k] == nums[k-1]) continue ;
            int i = k+1;
            int j = nums.length - 1 ;

            int target = 0 - nums[k] ;

            while(i < j) {
            
                if(nums[i] + nums[j] > target) {
                j-- ;
                while(i < j && nums[j] == nums[j+1]) j--;
                }
                
                else if(nums[i] + nums[j] < target) {
                    i++; 
                    while(i < j && nums[i] == nums[i-1]) i++;
                }
                else {
                    List<Integer> list = new ArrayList<>() ;
                    list.add(nums[k]) ;
                    list.add(nums[i]) ;
                    list.add(nums[j]) ;
                    ans.add(list) ;
                    i++;j--;
                    while(i < j && nums[j] == nums[j+1]) j--;
                    while(i < j && nums[i] == nums[i-1]) i++;
                    
                }
            }

        }

        return ans ;
    }
}