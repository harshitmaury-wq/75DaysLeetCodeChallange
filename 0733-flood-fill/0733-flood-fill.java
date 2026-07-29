class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> q = new LinkedList<>() ;
        int m = image.length;
        int n = image[0].length ;

        q.add(new int[]{sr, sc}) ;
        int[][] vis = new int[m][n] ;

        int ic = image[sr][sc] ;
        image[sr][sc] =color ;

        while(!q.isEmpty()) {
            int[] t = q.remove() ;
            int x = t[0] ;
            int y = t[1] ;
            vis[x][y] = 1 ;
            if(x + 1 < m && image[x+1][y] == ic && vis[x+1][y] == 0) {image[x+1][y] = color ; q.add(new int[]{x+1, y}) ;} 
            if(x - 1 >= 0  && image[x-1][y] == ic && vis[x-1][y] == 0) {image[x-1][y] = color ; q.add(new int[]{x-1, y}) ;}
            if(y + 1 < n && image[x][y+1] == ic && vis[x][y+1] == 0 ) {image[x][y+1] = color ; q.add(new int[]{x, y+1}); }
            if(y - 1 >= 0 && image[x][y-1] == ic && vis[x][y-1] == 0) {image[x][y-1] = color ; q.add(new int[]{x, y-1}); }
            
        }
        return image ;
    }
}