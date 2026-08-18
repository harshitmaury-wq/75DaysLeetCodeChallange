class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> list = new ArrayList<>() ;
        List<Integer> temp = new ArrayList<>() ;
        HashSet<List<Integer>> hs = new HashSet<>() ;

        fun(hs, temp, -1, 0, nums) ;
        for(List<Integer> li : hs) list.add(li) ;
        return list ;
    }
    void fun (HashSet<List<Integer>> list, List<Integer> temp, int p, int i, int[]nums) {
        if(i >= nums.length ) {
            if(temp.size() >= 2) list.add(new ArrayList<>(temp)) ;
            return ;
        }

        if(p == -1 || nums[i] >= nums[p] ) {
            
            temp.add(nums[i]) ;
            fun(list, temp, i, i+1, nums) ;
            temp.remove(temp.size() - 1) ;


            fun(list, temp, p, i+1 , nums) ;

        }

        else fun(list, temp, p, i+1 , nums) ;

        
    }
}