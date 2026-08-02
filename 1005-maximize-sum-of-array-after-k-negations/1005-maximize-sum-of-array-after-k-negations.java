class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        ArrayList<Integer> neg = new ArrayList<>() ;
        ArrayList<Integer> pos = new ArrayList<>() ;
        Arrays.sort(nums) ;

        for(int i = 0; i<nums.length; i++) {
            if(nums[i] < 0) neg.add(nums[i] ) ;
            else pos.add(nums[i]) ;
        }

        if(k <= neg.size()) {
            
            for(int i = 0; i < k; i++) neg.set(i, neg.get(i)*-1) ;
        } 

        else {
            for(int i = 0; i<neg.size(); i++) neg.set(i, neg.get(i)*-1) ;
            k -= neg.size() ;

            if(k%2 == 1 ) {
                if(neg.size()>0 && pos.size() > 0){
                if(neg.get(neg.size() -1 ) < pos.get(0)) neg.set(neg.size()-1 , neg.get(neg.size() -1 )*-1) ;
                else pos.set(0, pos.get(0)*-1) ;
                }
                else if(neg.size() == 0) pos.set(0, pos.get(0)*-1) ;
                else neg.set(neg.size()-1 , neg.get(neg.size() -1 )*-1) ;
            } 


        }
        int sum = 0;
        for(int i = 0; i<neg.size(); i++) sum+=neg.get(i) ;
        for(int i = 0; i<pos.size(); i++) sum+=pos.get(i) ;

        return sum ;

    }
}