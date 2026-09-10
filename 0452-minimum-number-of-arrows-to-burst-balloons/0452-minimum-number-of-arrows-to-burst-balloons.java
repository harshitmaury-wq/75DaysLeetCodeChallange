class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b) -> {return Long.compare(a[1],b[1]) ;}) ;

        int c = 1;
        long check = points[0][1] ;

        for(int i = 1; i<points.length; i++) {
            if(points[i][0] > check){
                c++;
                check = points[i][1] ;
            }
        }
        return c ;
    }
}