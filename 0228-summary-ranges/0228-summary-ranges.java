class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        List<String> list = new ArrayList<>() ;
        if(nums.length == 0) return list ;
        StringBuilder sb = new StringBuilder();
        int last = nums[0] ;
        for(int i = 1; i<nums.length; i++) {
            if(nums[i]-1 != nums[i-1]) {
                sb.setLength(0) ;
                if(last == nums[i-1]) sb.append(last) ;
                else {
                    sb.append(last) ;
                    sb.append("->");
                    sb.append(nums[i-1]) ;
                    
                    
                }
                list.add(sb.toString()) ;
                last = nums[i] ;
            }
        }  

        if(last == nums[nums.length - 1]) {
            list.add(new String(Integer.toString(last))) ;
        }
        else {
            list.add(new String(Integer.toString(last) + "->" + Integer.toString(nums[nums.length - 1]))) ;
        }
        return list ;      
    }
}