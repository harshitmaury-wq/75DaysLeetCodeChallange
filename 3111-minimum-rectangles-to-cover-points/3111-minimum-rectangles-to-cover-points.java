class Solution {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        Arrays.sort(points, (a,b) -> {return a[0]-b[0]; } ) ; 

        int c = 1;
        int curr = points[0][0] + w  ;

        for(int i = 1; i<points.length; i++) {
            if(points[i][0] > curr) {
                c++;
                curr = points[i][0] + w;
            }
        }

        return c ;
    }
}