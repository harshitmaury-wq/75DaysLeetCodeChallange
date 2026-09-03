class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> ans = new ArrayList<>() ;
        HashSet<List<Integer>> hs = new HashSet<>() ;
        Arrays.sort(nums) ;

        for(int i = 0; i<nums.length; i++) {
            for(int j = i + 1; j<nums.length; j++) {
                int x = j + 1 ;
                int y = nums.length - 1 ;

                long sum = (long) target - nums[i] - nums[j] ;
                
                while(x < y) {
                    long s = (long)nums[x] + nums[y];
                    if(s > sum) y-- ;
                    else if(s < sum) x++ ;
                    else {
                        List<Integer> list= new ArrayList<>() ;
                        list.add(nums[i]) ;
                        list.add(nums[j]) ;
                        list.add(nums[x]) ;
                        list.add(nums[y]) ;
                        hs.add(list) ;
                        x++; y--;
                    }
                    
                }
            }
        }

       for(List<Integer> l : hs) ans.add(l) ;

       return ans ;
    }
}