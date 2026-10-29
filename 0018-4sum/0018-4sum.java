class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>() ;
        Arrays.sort(nums) ;

        for(int i = 0; i<nums.length - 3; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue ;

            for(int j = i + 1; j < nums.length-2; j++) {
                if(j > i+1 && nums[j] == nums[j-1]) continue ;

                long t = target - (long)(nums[i] + nums[j]) ;

                int l = j + 1;
                int r = nums.length - 1 ;

                while(l < r) {
                    if((long) (nums[l] + nums[r]) < t ) {
                        l++;
                        while(l < r && nums[l] == nums[l-1]) l++;
                    }
                    else if((long) (nums[l] + nums[r]) > t) {
                        r--;
                        while(l < r && nums[r] == nums[r+1]) r--;
                    }
                    else {
                        List<Integer> temp = new ArrayList<>() ;
                        temp.add(nums[i]) ;
                        temp.add(nums[j]) ;
                        temp.add(nums[l]) ;
                        temp.add(nums[r]) ;
                        list.add(temp) ;

                        l++;
                        while(l < r && nums[l] == nums[l-1]) l++;

                        r--;
                        while(l < r && nums[r] == nums[r+1]) r--;
                    }
                }
            }
        }

        return list ;
    }
}