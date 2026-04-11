class Solution {
    class Node {
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<Node> q = new LinkedList<>() ;
        int m = image.length;
        int n = image[0].length;
        q.add(new Node(sr, sc)) ;
        
        int stpixel = image[sr][sc] ;

        image[sr][sc] = color ;

        if(color == stpixel) return image ;
        while(!q.isEmpty()){
            Node temp = q.remove() ;

            if(temp.y+1 < n && image[temp.x][temp.y+1] == stpixel){
                image[temp.x][temp.y+1] = color;
                q.add(new Node(temp.x, temp.y+1)) ;
            }
            if(temp.y-1 >= 0 && image[temp.x][temp.y-1] == stpixel){
                image[temp.x][temp.y-1] = color;
                q.add(new Node(temp.x, temp.y-1)) ;
            }
            if(temp.x+1 < m && image[temp.x+1][temp.y] == stpixel){
                image[temp.x+1][temp.y] = color;
                q.add(new Node(temp.x+1, temp.y)) ;
            }
            if(temp.x-1 >= 0 && image[temp.x-1][temp.y] == stpixel){
                image[temp.x-1][temp.y] = color;
                q.add(new Node(temp.x-1, temp.y)) ;
            }
        }
        return image ;
    }
}