class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] in) {
       
       List<List<Integer>> list = new ArrayList<>() ;
        for(int i = 0; i<n; i++) list.add(new ArrayList<>()) ;
       for(int i = 0; i < in.length; i++) {
           list.get(in[i][0]).add(in[i][1]) ;
       }

        int[] vis = new int[n] ;
        fun(list, vis, k) ;
        boolean b = false ;

        for(int i = 0; i<in.length; i++) {
           
            if(vis[in[i][0]] == 1) continue ;

            if(vis[in[i][1]] == 1) {b = true ; break; } 

        }
        List<Integer> ans = new ArrayList<>() ;
        if(b) {
            for(int i = 0; i<n; i++) ans.add(i) ;
        }

        else {
            for(int i= 0; i<vis.length; i++) {
                if(vis[i] == 0) ans.add(i) ;
            }
        }
        return ans ;

    }
    void fun (List<List<Integer>> list, int[] vis, int s) {
        if(vis[s] == 1 ) return  ;

        vis[s] = 1 ;
        for(int i = 0; i<list.get(s).size(); i++) {
            fun(list, vis, list.get(s).get(i)) ;
        }
    }
}