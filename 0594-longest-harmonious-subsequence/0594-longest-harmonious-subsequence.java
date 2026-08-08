class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums) ;

        ArrayList<int[]> list = new ArrayList<>() ;

        int i = 0;
        int c = 1 ; 
        while(i<nums.length) {
            while(i<nums.length-1 && nums[i+ 1] == nums[i]){c++; i++; } 

            list.add(new int[]{nums[i], c} ) ;
            c = 1 ;

            i++;
        }

        int max = 0 ;

        i = 1; 
        while(i < list.size()) {
            if(list.get(i)[0] - list.get(i-1)[0] == 1) {
                max = Math.max(max,list.get(i)[1] +  list.get(i-1)[1]) ;
            }
            i++;
        }

        return max ;
    }
}