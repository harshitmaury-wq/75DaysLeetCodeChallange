class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        ArrayList<int[]> list = new ArrayList<>() ;

        for(int i = 0; i<segments.length; i++){
            int[] arr1 = new int[]{segments[i][0], segments[i][2]} ;
            int[] arr2 = new int[]{segments[i][1], -1*segments[i][2]} ;
            list.add(arr1) ;
            list.add(arr2) ;
        }
        Collections.sort(list, (a,b) -> {
            if(a[0] < b[0]) return -1;
            else if(a[0] > b[0]) return 1;
            else {
                if(a[1] > b[1]) return 1;
                else if(a[1] < b[1]) return -1;
                else return 0;
            }
        }) ;

        List<List<Long>> ans = new ArrayList<>() ;
        int i = 0;
          long sum = 0;
        while(i<list.size()) {
          
            while(i<list.size() -1 && list.get(i)[0] == list.get(i+1)[0]){
                sum+=list.get(i)[1] ;
                i++;
            }
              sum+=list.get(i)[1] ;
              if(sum == 0) {i++ ; continue;}
            List<Long> t = new ArrayList<>() ;
            t.add((long)list.get(i)[0]) ;
            t.add((long)list.get(i+1)[0]) ;
            t.add(sum) ;
            i++;
            ans.add(t) ;
        }
        return ans ;
    }
}