class Solution {
    class Node{
        int x;
        int y;
        int w;
        Node(int x, int y, int w){
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        
        int[][] dis = new int[heights.length][heights[0].length] ;
        int r = heights.length;
        int c = heights[0].length;
        if(r==1 && c==1) return 0;
        for(int i=0; i<heights.length; i++){
            for(int j=0; j<heights[i].length; j++){
                dis[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> {return a.w - b.w ;}) ;

        pq.add(new Node(0,0,0));

        while(!pq.isEmpty()){
            Node temp = pq.remove();
            int x = temp.x;
            int y = temp.y;
            int w = temp.w;

            if(x+1 < r ){
                if(Math.max(Math.abs(heights[x][y] - heights[x+1][y]), w) < dis[x+1][y]){
                pq.add(new Node(x+1, y, Math.max(w ,Math.abs(heights[x][y] - heights[x+1][y])))) ;
                dis[x+1][y] =  Math.max(Math.abs(heights[x][y] - heights[x+1][y]), w) ;}

            }
             if(y+1 < c ){
                if(Math.max(Math.abs(heights[x][y] - heights[x][y+1]), w) < dis[x][y+1]){
                pq.add(new Node (x, y+1, Math.max(w ,Math.abs(heights[x][y] - heights[x][y+1])))) ;
                dis[x][y+1] = Math.max(Math.abs(heights[x][y] - heights[x][y+1]), w); }

            }
             if(x-1 >= 0 ){
                if(Math.max(Math.abs(heights[x][y] - heights[x-1][y]), w) <  dis[x-1][y]){
                pq.add(new Node (x-1, y, Math.max(w ,Math.abs(heights[x][y] - heights[x-1][y])))) ;
                dis[x-1][y] = Math.max(Math.abs(heights[x][y] - heights[x-1][y]), w); }

            }
             if(y-1 >= 0 ){
                if(Math.max(Math.abs(heights[x][y] - heights[x][y-1]), w) < dis[x][y-1]) {
                pq.add(new Node (x, y-1, Math.max(w ,Math.abs(heights[x][y] - heights[x][y-1])))) ;
                dis[x][y-1] = Math.max(Math.abs(heights[x][y] - heights[x][y-1]), w); }

            }
            

        }

        return dis[r-1][c-1] ;

    }
}