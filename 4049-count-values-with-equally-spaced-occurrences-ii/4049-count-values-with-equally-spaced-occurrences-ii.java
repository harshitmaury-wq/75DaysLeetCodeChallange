class Solution {
    public int countSpecialIntegers(int[] nums) {
        HashMap<Integer, List<Integer>> hm = new HashMap<>() ;

        for(int i = 0; i<nums.length; i++) {
            if(hm.containsKey(nums[i])) hm.get(nums[i]).add(i);
            else {
                List<Integer> l = new ArrayList<>() ;
                l.add(i) ;
                hm.put(nums[i], l) ;
            }
        }
        int c = 0 ;
        for(Integer i : hm.keySet()){
            if(hm.get(i).size() < 3) continue ;

            List<Integer> list = hm.get(i) ;
            int dis = list.get(1) - list.get(0) ;
            boolean b = true;
            for(int j = 1; j<list.size(); j++) {
                if(list.get(j) - list.get(j-1) != dis) {
                    b = false ;
                    break;
                }
            }
            if(b) c++ ; 
        }

        return c ;
    }
}