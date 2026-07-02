class Solution {
    public List<List<Integer>> filterOccupiedIntervals(int[][] oi, int fs, int fe) {
        Stack<int[]> st = new Stack<>() ;

        Arrays.sort(oi, (a,b) -> {return a[0]-b[0] ;} ) ;

        int i = 0;
        while(i<oi.length){
            if(st.isEmpty()) {st.push(oi[i]); i++; continue; }

            if(oi[i][0] <= st.peek()[1] || oi[i][0]-1 == st.peek()[1] ){
                st.peek()[1] = Math.max(st.peek()[1], oi[i][1]) ;
            }
            else st.push(oi[i]) ;
            i++ ;
        }
        ArrayList<int[]> list = new ArrayList<>() ;
        while(!st.isEmpty()) {
            list.add(st.pop()) ;
        }
        Collections.reverse(list) ;
       i = 0; 
       List<List<Integer>> ans = new ArrayList<>() ;
       while(i<list.size()) {
          if(fs > list.get(i)[1] || fe < list.get(i)[0]){
            List<Integer> temp = new ArrayList<>() ;
            temp.add(list.get(i)[0]) ;
            temp.add(list.get(i)[1]) ;
            ans.add(temp) ;
           } 
           else if(list.get(i)[0] >= fs && list.get(i)[1] <= fe) {i++; continue ; }
          else if (list.get(i)[0] < fs && list.get(i)[1] > fe) {
            List<Integer> temp = new ArrayList<>() ;
            List<Integer> temp2 = new ArrayList<>() ;

            temp.add(list.get(i)[0]) ;
            temp.add(fs-1) ;
            temp2.add(fe+1) ;
            temp2.add(list.get(i)[1]) ;
            ans.add(temp) ;
            ans.add(temp2) ;
           }
           else if(list.get(i)[0] < fs) {
            List<Integer> temp = new ArrayList<>() ;
            temp.add(list.get(i)[0]) ;
            temp.add(fs-1) ;
            ans.add(temp) ;
           }
            else if(list.get(i)[1] > fe) {
            List<Integer> temp = new ArrayList<>() ;
            temp.add(fe+1) ;
            temp.add(list.get(i)[1]) ;
            ans.add(temp) ;
           }
           
           i++;
       }
       Collections.sort(ans, (a,b) -> { return a.get(0) - b.get(0) ; }) ;
        return ans ;

    }
}