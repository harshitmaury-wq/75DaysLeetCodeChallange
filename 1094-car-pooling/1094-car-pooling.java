class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        ArrayList<int[]> list = new ArrayList<>() ;

        for(int i = 0; i<trips.length; i++){
            int[] arr1 = new int[]{trips[i][1], trips[i][0]} ;
            int[] arr2 = new int[]{trips[i][2], -1*trips[i][0]} ;
            list.add(arr1) ;
            list.add(arr2) ;
        }
        Collections.sort(list, (a,b) -> {
            if(a[0] < b[0]) return -1; 
            else if(a[0] > b[0]) return 1; 
            else {
                if(a[1] < b[1]) return -1; 
                else if(a[1] > b[1]) return 1; 
                else return 0;
            }
        }) ;

        int cap = 0;
        for(int i = 0; i<list.size(); i++){
            cap += list.get(i)[1] ;
            if(cap > capacity) return false ;
        }
        return true ;
    }
}