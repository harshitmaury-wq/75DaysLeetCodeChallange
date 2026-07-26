class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] s1, int[][] s2) {
       
       

        List<List<Integer>> list = new ArrayList<>() ;
        HashSet<List<Integer>> ans = new HashSet<>() ;
        for(int i = 0; i< s1.length; i++) {
            List<Integer> t = new ArrayList<>() ;
            int time = s1[i][0] ;
            int x = bs(s2, time) ;
            int val = s1[i][1] + (x == -1 ? 0 : s2[x][1]) ;
            t.add(time) ;
            t.add(val) ;
            ans.add(t) ;
        }

          for(int i = 0; i< s2.length; i++) {
            List<Integer> t = new ArrayList<>() ;
            int time = s2[i][0] ;
            int x = bs(s1, time) ;
            int val = s2[i][1] + (x == -1 ? 0 : s1[x][1]) ;
            t.add(time) ;
            t.add(val) ;
                ans.add(t) ;
        }

        for(List<Integer> l : ans) {
            list.add(l) ;
        }

        Collections.sort(list, (a, b) -> { return a.get(0) - b.get(0) ;}) ;
        return list ;
        
    }
    int bs (int[][] arr, int t) {
        int s = 0;
        int e = arr.length-1; 
        int ans = -1;
        while(s<=e) {
            int mid = s + (e - s) / 2 ;

            if(arr[mid][0] < t) s= mid + 1 ;
            else {
                ans = mid ;
                e = mid - 1;
            }
        }
        return ans ;
    }
}