class Solution {
    public int maxScore(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>() ;

        for(int x : nums) list.add(x) ;
        Collections.sort(list) ;
        Collections.reverse(list) ;

        long[] pre = new long[nums.length] ;
         int s = 0; 
        pre[0] = list.get(0) ;
        if(pre[0] > 0) s++ ;
        for(int i = 1; i<pre.length; i++) {
            pre[i] = pre[i-1] + list.get(i) ;
            if(pre[i] > 0) s++;
        }
       
        return s ;
        
    }
}