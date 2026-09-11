class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        ArrayList<int[]> list  = new ArrayList<>() ;

        for(int i = 0; i<queries.length; i++) {
            list.add(new int[]{queries[i]-x, i}) ;
        }

        Collections.sort(list, (a,b) -> {
            if(a[0] < b[0]) return -1;
            else if(a[0] > b[0]) return 1 ;
            else {
                if(a[1] < b[1]) return -1;
                else if(a[1] > b[1]) return 1;
                else return 0 ;
            }
        }) ;

        Arrays.sort(logs, (a,b) -> {return a[1] - b[1] ;}) ;

        int l = 0;
        int r = 0;
        HashMap<Integer, Integer> hm= new HashMap<>() ;

        int[] ans = new int[queries.length] ;

        for(int i = 0; i<list.size(); i++) {
            int start = list.get(i)[0] ;
            int end = list.get(i)[0] + x ;
            int idx = list.get(i)[1] ;

            while(r < logs.length && logs[r][1] <= end) {
                hm.put(logs[r][0], hm.getOrDefault(logs[r][0], 0) + 1) ;
                r++ ;
            }

            while(l < logs.length && logs[l][1] < start) {
                hm.put(logs[l][0], hm.get(logs[l][0]) -1 ) ;
                if(hm.get(logs[l][0]) == 0) hm.remove(logs[l][0]) ;
                l++ ;
            }
            ans[idx] = n - hm.size() ;
        }

        return ans ;
    }
}