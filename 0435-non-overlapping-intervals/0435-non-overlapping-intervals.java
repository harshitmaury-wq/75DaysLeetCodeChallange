class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        ArrayList<int[]> list = new ArrayList<>() ;

        for(int i=0; i<intervals.length; i++){
            list.add(intervals[i]) ;
        }

        Collections.sort(list ,(a,b) -> {
            
            if(a[1] < b[1]) return -1;
            else if(a[1]>b[1] ) return 1;
            else return 0;

        }); 
        int count = 0;
        int check = list.get(0)[1] ;
        for(int i=1; i<list.size(); i++){
            
            if(list.get(i)[0] >= check){
                count++;
                check = list.get(i)[1] ;
            }

        }
        return intervals.length-count-1;
    }
}