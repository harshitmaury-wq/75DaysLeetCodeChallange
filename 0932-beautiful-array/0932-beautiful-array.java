class Solution {
    public int[] beautifulArray(int n) {

        if(n == 1) return new int[]{1} ;

        int[] res = beautifulArray(n -1) ;

        ArrayList<Integer> list = new ArrayList<>() ;

        for(int i = 0; i< res.length; i++) {
            int odd_ele = 2*res[i] - 1 ;
            if(odd_ele <= n) list.add(odd_ele) ;
        }
        for(int i = 0; i< res.length; i++) {
            int even_ele = 2*res[i] ;
            if(even_ele <= n) list.add(even_ele) ;
        }
        
        int[] ans = new int[list.size()] ;
        for(int i = 0; i<ans.length; i++) ans[i] = list.get(i) ;

        return ans ;
    }
}