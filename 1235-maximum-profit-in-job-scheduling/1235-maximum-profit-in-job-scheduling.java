class Solution {
    public int jobScheduling(int[] st, int[] et, int[] pr) {
        int[] dp = new int[st.length+1];
        Arrays.fill(dp, -1) ;

        ArrayList<ArrayList<Integer>> list = new ArrayList<>() ;
        for(int i=0; i<st.length; i++) list.add(new ArrayList<>()) ;

        for(int i=0; i<st.length; i++){
            list.get(i).add(st[i]);
            list.get(i).add(et[i]);
            list.get(i).add(pr[i]);
        }
        Collections.sort(list, (a,b) -> {return a.get(0) - b.get(0) ;});
        return fun(list, 0, dp) ;
    }
    int fun(ArrayList<ArrayList<Integer>>list , int s, int[] dp){
        if(s >= list.size() ) return 0;

        if(dp[s] != -1) return dp[s] ;
        
        
        int take = list.get(s).get(2) + fun(list, getnxt(list, s+1, list.get(s).get(1)), dp);

        int skip = fun(list, s+1, dp) ;

        
        return dp[s] = Math.max(skip, take );
        
    }
    int getnxt(ArrayList<ArrayList<Integer>> list, int s, int t){
        int e = list.size()-1;
        int ans = list.size() ;

        while(s<=e){
            int mid = s + (e - s)/2;

            if(list.get(mid).get(0) >= t ) {ans = mid; e = mid - 1; }
            else s = mid+1;
        }
        return ans ;
    }
}